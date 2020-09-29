package hibernate.lesson7.dao;
import hibernate.lesson7.models.Hotel;
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
           // long tempId = (long) session.save(hotel);
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

    public Hotel delete(Hotel hotel) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.delete(hotel);
            tr.commit();
            System.out.println("Done delete");
            return hotel;
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
