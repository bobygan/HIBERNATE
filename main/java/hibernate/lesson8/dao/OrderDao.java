package hibernate.lesson8.dao;

import hibernate.lesson8.models.Filter;
import hibernate.lesson8.models.Order;
import hibernate.lesson8.models.Room;
import org.hibernate.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderDao {

    private    DAO<Order>dao= new DAO<>(Order.class);

    public Order save(Order ob) throws IllegalAccessException {
        return dao.save(ob);
    }

    public Order update(Order ob) {
        return dao.update(ob);
    }

    public void delete(long id) {
        dao.delete(id);
    }

    public Order findById(long id) {
        return dao.findById(id);
    }

    public Order findByRoom(Room room) {
        return dao.findByRoom(room);
    }



    public List<Room> findRooms(Filter filter) {
        Transaction tr = null;
        Room room = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Room> cr = cb.createQuery(Room.class);
            Root<Room> root = cr.from(Room.class);
            //   cr.select(root).where(cb.equal(root.getModel, filter));

            Query<Room> query = session.createQuery(cr);
            // query.setMaxResults(1);
            List<Room> result = query.getResultList();

            if(result.get(0)!=null) {
                System.out.println("Done findByFilter");
            }
            tr.commit();
            return result;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during findByName");
            e.printStackTrace();
            Throwable throwable = e;
            e.initCause(throwable);
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }
    }

    private static SessionFactory createSessionFactory() {
       // if (sessionFactory == null) {
         //   sessionFactory = new Configuration().configure().buildSessionFactory();
      //  }
        return null;//sessionFactory;
    }

}
