package hibernate.lesson5_1;

import hibernate.lesson5_2.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class ProductDao {

    private static SessionFactory sessionFactory;


    public static void saveAll(List<Product> products) {

        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.save(product);
            }
            tr.commit();


        } catch (HibernateException e) {
            System.err.println("save is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            System.out.println("Done save");
        }
    }
    public static void updateAll(List<Product> products) {

        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.save(product);
            }
            tr.commit();


        } catch (HibernateException e) {
            System.err.println("save is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            System.out.println("Done save");
        }
    }
    public static void deleteAll(List<Product> products) {

        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.save(product);
            }
            tr.commit();


        } catch (HibernateException e) {
            System.err.println("save is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            System.out.println("Done save");
        }
    }



    public  Product saved(Product product) {

        Session session = null;
        Transaction tr = null;
        long tempId = 0;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            tempId = (long) session.save(product);
            tr.commit();


        } catch (HibernateException e) {
            System.err.println("save is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            product.setId(tempId);
            System.out.println("Done save");
            return product;
        }

    }


        static Product save(Product product) {
            try (Session session = createSessionFactory().openSession()) {
                session.getTransaction().begin();
                session.save(product);
                long tempId = (long) session.save(product);
                session.getTransaction().commit();
                System.out.println("Done save");
                product.setId(tempId);
            }
            catch (HibernateException e) {
                System.err.println("Something went wrong during save");
                e.printStackTrace();
            }
            return product;
        }

    public  Product updated(Product product) {

        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();


            if (session.get(Product.class,product.getId())==null){
             new NullPointerException();
            }
            session.update(product);
            tr.commit();
            System.out.println("Done update");

        } catch (Exception e ) {
            System.err.println("update is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }


        } finally {
            if (session != null) {
                session.close();
            }

            return product;
        }
    }

    public static void delete(Product product) {

        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            session.delete(product);
            tr.commit();


        } catch (HibernateException e) {
            System.err.println("delete is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            System.out.println("Done delete");
        }
    }

    public static void get(Product product) {

        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //  session.get(Product.class, Id);
            tr.commit();


        } catch (HibernateException e) {
            System.err.println("update is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            System.out.println("Done update");
        }
    }

    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}


