package hibernate.lesson5_2;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class ProductDao {

    private static SessionFactory sessionFactory;


    public static void saveAll(List<Product> products) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.save(product);
            }
            tr.commit();
            System.out.println("Done saveAll");

        } catch (HibernateException e) {
            System.err.println("saveAll is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        }
    }

    public static void updateAll(List<Product> products) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.update(product);
            }
            tr.commit();
            System.out.println("Done updateAll");

        } catch (HibernateException e) {
            System.err.println("updateAll is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        }
    }

    public static void deleteAll(List<Product> products) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.delete(product);
            }
            tr.commit();
            System.out.println("Done deleteAll");

        } catch (HibernateException e) {
            System.err.println("deleteAll is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        }
    }


    public Product save(Product product) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.save(product);
            long tempId = (long) session.save(product);
            tr.commit();
            System.out.println("Done save");
            product.setId(tempId);
            return product;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during save");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }

    }

    public Product update(Product product) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.update(product);
            tr.commit();
            System.out.println("Done update");
            return product;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during update");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }

    }

    public Product delete(Product product) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.delete(product);
            tr.commit();
            System.out.println("Done delete");
            return product;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during delete");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }
    }

    private static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}


