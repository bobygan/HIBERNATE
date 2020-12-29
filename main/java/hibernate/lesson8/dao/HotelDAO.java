package hibernate.lesson8.dao;

import hibernate.lesson8.models.Hotel;

public class HotelDAO {

    private    DAO<Hotel>dao= new DAO<>(Hotel.class);

    public Hotel save(Hotel ob) throws IllegalAccessException {
        return dao.save(ob);
    }

    public Hotel update(Hotel ob) {
        return dao.update(ob);
    }

    public void delete(long id) {
           dao.delete(id);
    }

    public Hotel findById(long id) {
        return dao.findById(id);
    }

    public Hotel findByName(String name) {
     return    dao.findByNameHotel(name);
    }



    public Hotel findByCity(String city) throws IllegalAccessException {
        return dao.findByCity(city);
    }

}
