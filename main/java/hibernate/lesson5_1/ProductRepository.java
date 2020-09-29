package hibernate.lesson5_1;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ProductRepository {

    static void save(Product product) {
        try (Session session = new HibernateUtils().createSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.save(product);

            session.getTransaction().commit();
            System.out.println("Done save");
        } catch (HibernateException e) {
            System.err.println("Something went wrong during save");
            e.printStackTrace();
        }
    }

    public static void update(Product product) {
        try (Session session = new HibernateUtils().createSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.update(checkInDb(product.getId()));
            System.out.println("Done update");
            session.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Something went wrong during update");
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try (Session session = new HibernateUtils().createSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.delete(checkInDb(id));
            System.out.println("Done delete");
            session.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Something went wrong during delete");
            e.printStackTrace();
        }
    }

    private static Product checkInDb(long id) throws Exception {
        try (Session session = new HibernateUtils().createSessionFactory().openSession()) {
          //  session.getTransaction().begin();
            Product temp = session.get(Product.class, id);
           // session.getTransaction().commit();
            if (temp != null) {
                return temp;
            } else {
                System.out.println("Product id=" + id + " not found in DB");
                throw new Exception();
            }


        } catch (HibernateException e) {
            System.err.println("Something went wrong during check Product by ID");
            e.printStackTrace();
            throw e;
        }
    }

}
