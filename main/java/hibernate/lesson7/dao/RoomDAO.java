package hibernate.lesson7.dao;
import hibernate.lesson7.models.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RoomDAO {


    private static SessionFactory sessionFactory;


    public Room save(Room room) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.save(room);
            long tempId = (long) session.save(room);
            tr.commit();
            System.out.println("Done save");
            room.setId(tempId);
            return room;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during save");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }

    }

    public Room update(Room room) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.update(room);
            tr.commit();
            System.out.println("Done update");
            return room;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during update");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }

    }

    public Room delete(Room room) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.delete(room);
            tr.commit();
            System.out.println("Done delete");
            return room;
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
