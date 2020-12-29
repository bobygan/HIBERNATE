package hibernate.lesson8.controller;
import hibernate.lesson8.models.Filter;
import hibernate.lesson8.models.Hotel;
import hibernate.lesson8.models.Room;
import hibernate.lesson8.models.User;
import hibernate.lesson8.service.Service;

import java.sql.Date;
import java.util.List;

public class Controller {
 private Service service=new Service();

    public List<Room>findRooms(Filter filter){
        return service.faindRooms(filter);
    }
    public Hotel findHotelByName(String name){
       return  service.faindHotelByName(name);
    }

    public Hotel findHotelByCity(String city){
        return service.faindHotelByCity(city);
    }

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo){
           service.bookRoom(roomId,userId,dateFrom,dateTo);
    }

    public void cencelReservation(long roomId, long userId){
          service.cencelReservation(roomId,userId);
    }

    public void registerUser(User user){
          service.registerUser(user);
    }

    public void login(String userName, String password){
          service.login(userName,password);
    }

    public void logout(){}
}
