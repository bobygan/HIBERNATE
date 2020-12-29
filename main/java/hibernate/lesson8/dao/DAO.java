package hibernate.lesson8.dao;


import hibernate.lesson8.models.Filter;
import hibernate.lesson8.models.Room;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class DAO<T> {

    final Class<T> typeParameterClass;

    public DAO(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    @SuppressWarnings("unchecked")

    private static SessionFactory sessionFactory;

    public T save(T obT) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.save(obT);
            tr.commit();
            System.out.println("Done save " + obT.toString());

            return obT;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during save");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }
    }

    public T update(T obT) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.update(obT);
            tr.commit();
            System.out.println("Done update " + obT.toString());
            return obT;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during update Hotel");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }

    }

    public void delete(long id) {
        Transaction tr = null;
        T obT;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            obT = (T) session.get(typeParameterClass, id);
            if (obT != null) {
                session.delete(obT);
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

    public T findById(long id) {
        Transaction tr = null;
        T obT;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            obT = session.get(typeParameterClass, id);
            if (obT != null) {
                System.out.println("Done findById Hotel");

            }
            tr.commit();

            return obT;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during findById");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }
    }

    public T findByNameHotel(String name) throws HibernateException{
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cr = cb.createQuery(typeParameterClass);
            Root<T> root = cr.from(typeParameterClass);
            cr.select(root).where(cb.equal(root.get("name"), name));  //here you pass a class field, not a table column (in this example they are called the same)

            Query<T> query = session.createQuery(cr);
            query.setMaxResults(1);
            List<T> result = query.getResultList();

            if (result.get(0) != null) {
                System.out.println("Done findByNameHotel");
            }
            tr.commit();
            return result.get(0);
        } catch (HibernateException e) {
            System.err.println("Something went wrong during findByNameHotel");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
             throw new HibernateException (e);
        }
    }

    public T findByNameUser(String name)throws IllegalAccessException{
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cr = cb.createQuery(typeParameterClass);
            Root<T> root = cr.from(typeParameterClass);
            cr.select(root).where(cb.equal(root.get("userName"), name));  //here you pass a class field, not a table column (in this example they are called the same)

            Query<T> query = session.createQuery(cr);
            query.setMaxResults(1);
            List<T> result = query.getResultList();

            if (result.get(0) != null) {
                System.out.println("Done findByName");
            }
            tr.commit();
            return result.get(0);
        } catch (Exception e) {
            System.err.println("Cant findByName USER");
            //e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            //return null;
            // throw e;
            throw new IllegalAccessException();
        }
    }

    public T findByCity(String city) throws IllegalAccessException {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cr = cb.createQuery(typeParameterClass);
            Root<T> root = cr.from(typeParameterClass);

            cr.select(root).where(cb.equal(root.get("city"), city));  //here you pass a class field, not a table column (in this example they are called the same)

            Query<T> query = session.createQuery(cr);
            query.setMaxResults(1);
            List<T> result = query.getResultList();

            if (result.get(0) != null) {
                System.out.println("Done find By City");
            }
            tr.commit();
            return result.get(0);
        } catch (HibernateException e) {
            System.err.println("Something went wrong during findByName");
           // e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            // throw e;
            throw new IllegalAccessException();
        }
    }

    public T findByRoom(Room room) {
        Transaction tr = null;
        T obT;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cr = cb.createQuery(typeParameterClass);
            Root<T> root = cr.from(typeParameterClass);
            cr.select(root).where(cb.equal(root.get("room"), room));  //here you pass a class field, not a table column (in this example they are called the same)

            Query<T> query = session.createQuery(cr);
            query.setMaxResults(1);
            List<T> result = query.getResultList();

            if (result.get(0) != null) {
                System.out.println("Done findByRoom");
            }
            tr.commit();
            return result.get(0);
        } catch (HibernateException e) {
            System.err.println("Something went wrong during findByName");
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        }
    }

    public List<Room> findRooms(Filter filter) {
        Transaction tr = null;
        Room room = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();



            Criteria cr=session.createCriteria(Room.class);

            List<Criterion> criterionList = new ArrayList<Criterion>();
            if (0 != filter.getId())
                criterionList.add(Restrictions.eq("id", filter.getId()));
            if (0 != filter.getPrice())
                criterionList.add(Restrictions.eq("price", filter.getPrice()));
            if (0 != filter.getNumberOfGuests())
                criterionList.add(Restrictions.eq("NUMBEROFGUEST", filter.getNumberOfGuests()));
            if (true== filter.getBreakfastIncluded())
                 criterionList.add(Restrictions.eq("breakfastIncluded", filter.getBreakfastIncluded()));
            if (null != filter.getDateAvailableFrom())
                criterionList.add(Restrictions.like("DATEAVAILABLEFROM", filter.getDateAvailableFrom()));
            if (true== filter.isPetsAllowed())
                criterionList.add(Restrictions.eq("PETSALLOWED", filter.isPetsAllowed()));
            if (null != filter.getHotel())
                criterionList.add(Restrictions.or(Restrictions.eq("HOTEL", filter.getHotel())));



            if(null!=criterionList && !criterionList.isEmpty())
                for(Criterion criterion:criterionList)
                    if(null!=criterion){
                        cr.add(criterion);
                        System.out.println("filter key: "+criterion);
                    }

            tr.commit();
            System.out.println("Done findByFilter");
            return cr.list();


        //    if (result.get(0) != null) {
          //      System.out.println("Done findByFilter");
          //  }
          //  tr.commit();
          //  return result;
        } catch (HibernateException e) {
            System.err.println("Something went wrong during findByFilter");
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
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}













