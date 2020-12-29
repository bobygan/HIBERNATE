package hibernate.lesson7.demo;
import hibernate.lesson7.dao.HotelDAO;
import hibernate.lesson7.dao.RoomDAO;
import hibernate.lesson7.models.Hotel;
import hibernate.lesson7.models.Room;

import java.sql.Date;

public class  Demo {
    public static void main(String[] args) {
        Hotel hotel=new Hotel();
        hotel.setCity("Reni");
        hotel.setCountry("UA");
        hotel.setName("STAR");
        hotel.setStreet("LENINA");
        hotel.setId(10);

        Room room=new Room();
        room.setNumberOfGuests(2);
        room.setBreakfastIncluded(1);
        Date date;
     //   room.setDateAvailableFrom(date);
        room.setHotel(hotel);
        room.setId(12);

        System.out.println(room);


        HotelDAO hotelDAO=new HotelDAO();
        RoomDAO roomDAO=new RoomDAO();
      //  hotelDAO.save(hotel);
         roomDAO.save(room);

    }
}
