package hibernate.lesson8.demo;

import hibernate.lesson8.dao.HotelDAO;
import hibernate.lesson8.dao.UserDAO;
import hibernate.lesson8.models.Hotel;
import hibernate.lesson8.models.User;

public class Demo {

    public static void main(String[] args) {

        User user=new User();
        user.setId(8);
        user.setPassword("123");

        Hotel hotel=new Hotel();
        hotel.setId(12);
      //  Room room=new Room();
      //  room.setId(1);
       // room.setHotel(hotel);
      //  Order order=new Order();
      //  Room room=new Room();
    //    Filter filter=new Filter();


        UserDAO userDAO=new UserDAO();
       // RoomDAO roomDAO=new RoomDAO();
       HotelDAO hotelDAO= new HotelDAO();


 



        try {
            hotelDAO.save(hotel);
          //roomDAO.save(room);

           // userDAOsave(user);
        } catch (Exception e) {
        }


     //  System.exit(1);




//        ArrayList<File> arrayList = new ArrayList<>();
  ///      arrayList.add(file4);
     //   arrayList.add(file5);
    //    arrayList.add(file6);
      //  arrayList.add(file7);
     //   arrayList.add(file8);
     //   try {
       //     controller.putAll(storage0, arrayList);
     //   } catch (Exception e) {
      //  }

      //  try {
        //    controller.transferAll(storage4, storage1);
       // } catch (Exception e) {
       // }

       // try {
         //   controller.transferFile(storage4, storage2, 4);
        //} catch (Exception e) {
       // }


    }

}
