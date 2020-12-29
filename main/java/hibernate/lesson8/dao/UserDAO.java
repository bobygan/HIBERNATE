package hibernate.lesson8.dao;
import hibernate.lesson8.models.User;

public class UserDAO {

    private    DAO<User>dao= new DAO<>(User.class);

    public User save(User ob)  {
        return dao.save(ob);
    }
    public User update(User ob) {
        return dao.update(ob);
    }
    public void delete(long id) {
        dao.delete(id);
    }
    public User findById(long id) {
        return dao.findById(id);
    }
    public User findByName(String name) throws IllegalAccessException{
        return dao.findByNameUser(name);
    }


}
