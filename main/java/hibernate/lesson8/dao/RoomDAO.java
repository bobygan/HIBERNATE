package hibernate.lesson8.dao;
import hibernate.lesson8.models.Filter;
import hibernate.lesson8.models.Room;

import java.util.List;

public class RoomDAO {


    private    DAO<Room>dao= new DAO<>(Room.class);

    public Room save(Room ob) throws IllegalAccessException {
        return dao.save(ob);
    }

    public Room update(Room ob) {
        return dao.update(ob);
    }

    public void delete(long id) {
        dao.delete(id);
    }

    public Room findById(long id) {
        return dao.findById(id);
    }

    public List<Room> findRooms(Filter filter) {
        return dao.findRooms(filter);
    }


}
