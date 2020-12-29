package hibernate.lesson8.service;
import hibernate.lesson8.dao.HotelDAO;
import hibernate.lesson8.dao.OrderDao;
import hibernate.lesson8.dao.RoomDAO;
import hibernate.lesson8.dao.UserDAO;
import hibernate.lesson8.models.*;

import java.sql.Date;
import java.util.List;

public class Service {
      private HotelDAO hotelDAO = new HotelDAO();
      private UserDAO userDAO=new UserDAO();
      private RoomDAO roomDAO=new RoomDAO();
      private OrderDao orderDao=new OrderDao();
      public static Boolean login=false;

     public User registerUser(User user) {
         try{userDAO.findByName(user.getUserName());
             System.out.println("User already registered with this name");
             return null;
         }
         catch (Exception e){
             return userDAO.save(user);
         }


     }

    public Hotel faindHotelByName(String name){
        if (login==false){
            throw new IllegalStateException("Login for access to DB  !!!!!!!");
        }
         return hotelDAO.findByName(name);
    }

    public Hotel faindHotelByCity(String city){
        try {
            return hotelDAO.findByCity(city);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) {

        User user = userDAO.findById(userId);
        Room room = roomDAO.findById(roomId);
        Order order = orderDao.findByRoom(room);


        if ((order.getDateFrom()).before(dateFrom)) {
            throw new IllegalStateException("Room already booking from");
        }

        if ((order.getDateFrom()).before(dateFrom)) {
            throw new IllegalStateException("Room already booking to");
        }

        order.setId(20);
        order.setRoom(room);
        order.setUserOrdered(user);
        order.setDateTo(dateTo);
        order.setDateFrom(dateFrom);
        try {
            orderDao.save(order);
        }catch (Exception e){
            System.err.println("Something went wrong during save orders");
        }


    }

    public void cencelReservation(long roomId, long userId){
        User user=userDAO.findById(userId);
        for (  Order temp:user.getOrders()){
        if   (temp.getId()==roomId){
            user.getOrders().remove(temp);
            userDAO.update(user);
            System.out.println(temp.toString()+"censeled");
            return;
            }
        }
    }

    public List<Room>faindRooms(Filter filter){
         return roomDAO.findRooms(filter);
    }

    public void login(String userName, String password){
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + userName);
        System.out.print("Password: ");
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }

        if( userDAO.findByName(userName).getPassword().equals(password)){
            login=true;
            System.out.println("\n\nLogIn success !!!!");
        }
    }

    public void logout(){
        login=false;
    }
}
