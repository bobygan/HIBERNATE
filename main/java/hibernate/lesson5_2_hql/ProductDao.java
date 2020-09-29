package hibernate.lesson5_2_hql;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;


public class ProductDao {

    private static SessionFactory sessionFactory;


    public List<Product> findById(Long id) {
        try (Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Product where id=" + id);
            List<Product> products = query.getResultList();
            System.out.println("Done findById");
            return products;
        } catch (HibernateException e) {
            System.err.println("findById is failed");
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public List<Product> findByName(String name) {
        try (Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Product where name=:name");
            query.setParameter("name", name);
            List<Product> products = query.getResultList();
            System.out.println("Done findByName");
            return products;
        } catch (HibernateException e) {
            System.err.println("findByName is failed");
            System.err.println(e.getMessage());
            throw e;
        }

    }

    public List<Product> findByContainedName(String name) {
        try (Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Product where (name LIKE  :name)");
            query.setParameter("name", "%" + name + "%");
            List<Product> products = query.getResultList();
            System.out.println("Done findByIdContainedName");
            return products;
        } catch (Exception e) {
            System.err.println("findByIdContainedName is failed");
            System.err.println(e.getMessage());
            throw e;
        }

    }

    public List<Product> findByPrice(int price, int delta) {
        try (Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Product where (price>=:priceMin)AND(price<=:priceMax) ");
            query.setParameter("priceMin", price - delta);
            query.setParameter("priceMax", price + delta);
            List<Product> products = query.getResultList();
            System.out.println("Done findByPrice");
            return products;
        } catch (Exception e) {
            System.err.println("findByPrice is failed");
            System.err.println(e.getMessage());
            throw e;
        }

    }

    public List<Product> findByNameSortedAsc() {
        try (Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Product  ORDER BY name ASC");
            List<Product> products = query.getResultList();
            System.out.println("Done findByNameSortedAsc");
            return products;
        } catch (Exception e) {
            System.err.println("findByNameSortedAsc is failed");
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public List<Product> findByNameSortedDecs() {
        try (Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Product  ORDER BY name DESC");
            List<Product> products = query.getResultList();
            System.out.println("Done findByName");
            return products;
        } catch (Exception e) {
            System.err.println("findByName is failed");
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public List<Product> findByPriceSortedDesc(int price, int delta) {
        try (Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Product where (price>=:priceMin)AND(price<=:priceMax) ORDER BY price DESC ");
            query.setParameter("priceMin", price - delta);
            query.setParameter("priceMax", price + delta);
            List<Product> products = query.getResultList();
            System.out.println("Done findByPrice");
            return products;
        } catch (Exception e) {
            System.err.println("findByPrice is failed");
            System.err.println(e.getMessage());
            throw e;
        }
    }


    private SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}


