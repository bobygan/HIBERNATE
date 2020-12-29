package hibernate.lesson8.demo;

import hibernate.lesson8.controller.Controller;
import hibernate.lesson8.dao.DAO;
import hibernate.lesson8.dao.HotelDAO;
import hibernate.lesson8.dao.RoomDAO;
import hibernate.lesson8.dao.UserDAO;
import hibernate.lesson8.models.*;

import java.util.ArrayList;
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
                    "3 - Exit");
            choice = Integer.parseInt(reader.readLine());

            if (choice == 1) {
                System.out.print("Input user name: ");
                String userName = reader.readLine();
                System.out.print("Input password: ");
                String password = reader.readLine();
                controller.login(userName, password);

                do {
                    System.out.println("\nChoose.\n" +
                            "1 - findHotelByCity\n" +
                            "2 - findHotelByName\n" +
                            "3 - findRoomsByFilter\n" +
                            "4 - Exit");
                    choice = Integer.parseInt(reader.readLine());

                    if (choice == 1) {
                        System.out.print("Input hotel city: ");
                        System.out.println(controller.findHotelByCity(reader.readLine()).toString());


                    } else if (choice == 2) {
                        System.out.print("Input hotel name: ");
                        System.out.println(controller.findHotelByName(reader.readLine()).toString());

                    } else if (choice == 3) {
                        Filter filter=new Filter();
                        System.out.print("Input prise: ");

                        filter.setPrice(Double.parseDouble(reader.readLine()));
                        for (Room room : controller.findRooms(filter))
                            System.out.println(room.toString());

                    }

                } while (choice != 4);

            } else if (choice == 2) {
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
        }
            while (choice != 3) ;


            User user = new User();
            user.setId(16);
            user.setPassword("12");
            user.setUserName("Ivan10");
            user.setCountry("Odessa");
            UserType userType = UserType.USER;
            user.setUserType(userType);
            Order order = new Order();
            order.setId(2);

            Room room = new Room();
            room.setId(520);
            room.setNumberOfGuests(100);
            room.setPrice(25);
            room.setBreakfastIncluded(true);
            ArrayList<Room> listRoom = new ArrayList<>();
            listRoom.add(room);
            //////////////////////////////////
            Hotel hotel = new Hotel();
            hotel.setId(235);
            hotel.setName("odessa");
            hotel.setCountry("UA");
            hotel.setCity("RENI");
            hotel.setRooms(listRoom);


            Filter filter = new Filter();
            filter.setId(12);
            filter.setPrice(25);

            //   room.setHotel(hotel);
            // room.setHotel(hotel);

            //  Room room=new Room();
            //    Filter filter=new Filter();


            UserDAO userDAO = new UserDAO();
            RoomDAO roomDAO = new RoomDAO();
            HotelDAO hotelDAO = new HotelDAO();
            DAO dao = new DAO(Hotel.class);


            //  controller.registerUser(user);
            //  controller.faindHotelByName("ss");
            //  controller.login("Ivan10","12");
            //  System.out.println( controller.faindHotelByName("sss").toString());
            // Service service=new Service();
            //System.out.println( controller.faindHotelByCity("OD").toString());
            System.out.println(controller.findRooms(filter).

                    toString());

            //dao.getGenericTypeClass();
            try {
//    hotelDAO.save(hotel);
                //   hotelDAO.delete(200);
                //  roomDAO.save(room);
                //  userDAO.save(user);
            } catch (
                    Exception e) {
                System.out.println("lkecjhurekj ");
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


        }


    }