package hibernate.lesson8.demo;

import hibernate.lesson8.controller.Controller;
import hibernate.lesson8.models.Filter;
import hibernate.lesson8.models.Room;
import hibernate.lesson8.models.User;
import hibernate.lesson8.models.UserType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {


    public static void main(String[] args) throws IOException {

        Controller controller = new Controller();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;

        do {
            System.out.println("\nChoose.\n" +
                    "1 - login\n" +
                    "2 - Register User\n" +
                    "3 - logout\n" +
                    "4 - findHotelByCity\n" +
                    "5 - findHotelByName\n" +
                    "6 - findRoomsByFilter\n" +
                    "7 - bookRoom\n" +
                    "8 - canselReservation\n" +
                    "9 - Exit");
            choice = Integer.parseInt(reader.readLine());

            if (choice == 1) {
                System.out.print("Input user name: ");
                String userName = reader.readLine();
                System.out.print("Input password: ");
                String password = reader.readLine();
                controller.login(userName, password);
            }

            if (choice == 2) {
                User user = new User();
                System.out.print("Input user name: ");
                user.setUserName(reader.readLine());
                System.out.print("Input password: ");
                user.setPassword(reader.readLine());
                System.out.print("Input country: ");
                user.setCountry(reader.readLine());
                System.out.println("\nChoose.\n" +
                        "1 - ADMIN\n" +
                        "2 - USER");
                choice = Integer.parseInt(reader.readLine());

                if (choice == 1) {
                    user.setUserType(UserType.ADMIN);
                } else if (choice == 2) {
                    UserType userType = UserType.USER;
                }
                controller.registerUser(user);

            }

            if (choice == 3) {
                System.out.print("logout done: ");
                controller.logout();
            }

            if (choice == 4) {
                System.out.print("Input hotel city: ");
                System.out.println(controller.findHotelByCity(reader.readLine()).toString());
            }

            if (choice == 5) {
                System.out.print("Input hotel name: ");
                try {
                    System.out.println(controller.findHotelByName(reader.readLine()).toString());
                } catch (IllegalAccessException e) {
                }
            }

            if (choice == 6) {
                Filter filter = new Filter();
                System.out.print("Input prise: ");
                filter.setPrice(Double.parseDouble(reader.readLine()));
                System.out.print("\nChoose.\n" +
                        "0 - Without breakfast\n" +
                        "1 - Breakfast included");
                filter.setBreakfastIncluded(Boolean.parseBoolean(reader.readLine()));
                System.out.print("Input number of guests: ");
                filter.setNumberOfGuests(Integer.parseInt(reader.readLine()));

                for (Room rooms : controller.findRooms(filter)) {
                    if (null != rooms.getHotel()) {
                        rooms.getHotel().setRooms(null);
                    }
                    System.out.println(rooms.toString());
                }

            }



    }
        while(choice !=9);
}
}
/*

         //   User user = new User();
         //   user.setId(16);
        //    user.setPassword("12");
          //  user.setUserName("Ivan10");
         //   user.setCountry("Odessa");
         //   UserType userType = UserType.USER;
         //   user.setUserType(userType);
         ///   Order order = new Order();
         //   order.setId(2);

         //   Room room = new Room();
         //   room.setId(520);
         //   room.setNumberOfGuests(100);
         //   room.setPrice(25);
         //   room.setBreakfastIncluded(true);
         //   ArrayList<Room> listRoom = new ArrayList<>();
         //   listRoom.add(room);
            //////////////////////////////////
       //     Hotel hotel = new Hotel();
       //     hotel.setId(235);
       //     hotel.setName("odessa");
       //     hotel.setCountry("UA");
       //     hotel.setCity("RENI");
        //    hotel.setRooms(listRoom);


            Filter filter = new Filter();
            filter.setId(0);
            filter.setPrice(25);
            filter.setBreakfastIncluded(true);

            //   room.setHotel(hotel);
            // room.setHotel(hotel);

            //  Room room=new Room();
            //    Filter filter=new Filter();


      //      UserDAO userDAO = new UserDAO();
        ///    RoomDAO roomDAO = new RoomDAO();
        //    HotelDAO hotelDAO = new HotelDAO();

       // System.out.println( dao.findRooms(filter).d);
        for (Room rooms : controller.findRooms(filter)){
            if (null!=rooms.getHotel()){
                rooms.getHotel().setRooms(null);
            }
            System.out.println(rooms.toString());
        }

            //  controller.registerUser(user);
            //  controller.faindHotelByName("ss");
              controller.login("a","12");
          //    System.out.println( controller.findHotelByName("sss").toString());
            // Service service=new Service();
            //System.out.println( controller.faindHotelByCity("OD").toString());
        //    System.out.println(controller.findRooms(filter).

          //          toString());

            //dao.getGenericTypeClass();
          //  try {
//    hotelDAO.save(hotel);
                //   hotelDAO.delete(200);
                //  roomDAO.save(room);
                //  userDAO.save(user);
         //   } catch (
           //         Exception e) {
           //     System.out.println("lkecjhurekj ");
            }


            // try {
            //    hotelDAO.delete(12);

            // hotelDAO.update(hotel);
            //   roomDAO.save(room);
            //  roomDAO.delete(22);
            //userDAO.save(user);
            //   System.out.println (roomDAO.findRooms(filter));
            //    System.out.println( (hotelDAO.findById( 23)).toString());
            // System.out.println( (hotelDAO.findByName("sss")).toString());
            // System.out.println( (hotelDAO.findByCity("OD")).toString());
            // userDAOsave(user);
            // } catch (Exception e) {
            //   System.out.println("!!!!!!!!!!!!!!1");
            // }


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


      //  }


 */