package hibernate.lesson5_2_native;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class ProductDao {

    private static SessionFactory sessionFactory;


    public List<Product> findById(Long id) {
        try (Session session = createSessionFactory().openSession()) {
            String sql = "SELECT * FROM Product where ID=" + id;
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Product.class);
            List<Product> products = query.list();
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
            String sql = "SELECT * FROM Product where NAME ='" + name + "'";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Product.class);
            List<Product> products = query.list();
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
            String sql = "SELECT * FROM Product where NAME LIKE  '%" + name + "%'";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Product.class);
            List<Product> products = query.list();
            System.out.println("Done findByIdContainedName");
            return products;
        } catch (HibernateException e) {
            System.err.println("findByIdContainedName is failed");
            System.err.println(e.getMessage());
            throw e;
        }

    }

    public List<Product> findByPrice(int price, int delta) {
        try (Session session = createSessionFactory().openSession()) {
            int min = price - delta;
            int max = price + delta;
            String sql = "SELECT * FROM Product where (price>=" + min + ")AND(price<=" + max + ")";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Product.class);
            List<Product> products = query.list();
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
            String sql = "SELECT * FROM Product  ORDER BY name ASC";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Product.class);
            List<Product> products = query.list();
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
            String sql = "SELECT * FROM Product  ORDER BY name DESC";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Product.class);
            List<Product> products = query.list();
            System.out.println("Done findByNameSortedDecs");
            return products;
        } catch (Exception e) {
            System.err.println("findByNameSortedDecs is failed");
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public List<Product> findByPriceSortedDesc(int price, int delta) {
        try (Session session = createSessionFactory().openSession()) {
            int min = price - delta;
            int max = price + delta;
            String sql = "SELECT * FROM Product where (price>=" + min + ")AND(price<=" + max + ")ORDER BY price DESC";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Product.class);
            List<Product> products = query.list();
            System.out.println("Done findByPriceSortedDesc");
            return products;
        } catch (Exception e) {
            System.err.println("findByPriceSortedDesc is failed");
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


