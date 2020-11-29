package hibernate.lesson8.service;

import hibernate.lesson8.dao.DAO;
import hibernate.lesson8.models.User;

import java.sql.Date;

public class Service {
    private DAO dao = new DAO();

   // public Hotel faindHotelByName(String name){
     //   return dao.
    //}

   // public Hotel faindHotelByCity(String name){
      //  return
    //}


    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo){}

    public void cencelReservation(long roomId, long userId){}

    public void registerUser(User user){}

    public void login(String userName, String password){}

    public void logout(){}
}
