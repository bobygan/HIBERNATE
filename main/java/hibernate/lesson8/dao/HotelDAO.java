package hibernate.lesson8.dao;

import hibernate.lesson8.models.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HotelDAO {


    private static SessionFactory sessionFactory;
    public Hotel save(Hotel hotel) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.save(hotel);
          //  long tempId = (long) session.save(hotel);
            tr.commit();
            System.out.println("Done save");
          //  hotel.setId(tempId);
            return hotel;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during save");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }

    }

    public Hotel update(Hotel hotel) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.update(hotel);
            tr.commit();
            System.out.println("Done update");
            return hotel;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during update");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }

    }

    public void delete(Long id) {
        Transaction tr = null;
        Hotel hotel;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            hotel = (Hotel) session.load(Hotel.class, new Long(id));
            if(hotel!=null) {
                session.delete(hotel);
                System.out.println("Done delete");
            }
            tr.commit();

        } catch (HibernateException e) {
            System.err.println("Something went wrong during delete");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }
    }

    public Hotel findById(Long id) {
        Transaction tr = null;
        Hotel hotel;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            hotel = (Hotel) session.load(Hotel.class, new Long(id));
            if(hotel!=null) {
                System.out.println("Done findById");
            }
            tr.commit();
            return hotel;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during findById");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }
    }

    public Hotel findByName(String name) {
        Transaction tr = null;
        Hotel hotel;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            hotel = (Hotel) session.load(Hotel.class, new String(name));
            if(hotel!=null) {
                System.out.println("Done findByName");
            }
            tr.commit();
            return hotel;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during findByName");
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
