package hibernate.lesson8.controller;
import hibernate.lesson8.models.User;
import hibernate.lesson8.service.Service;

import java.sql.Date;

public class Controller {
 private Service service=new Service();


 //   public Hotel faindHotelByName(String name){

   //     return  service.faindHotelByName(name);
   // }

  //  public Hotel faindHotelByCity(String city){
    //    return service.faindHotelByCity(city);
   // }


    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo){}

    public void cencelReservation(long roomId, long userId){}

    public void registerUser(User user){}

    public void login(String userName, String password){}

    public void logout(){}
}
