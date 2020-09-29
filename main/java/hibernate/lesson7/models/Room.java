package hibernate.lesson7.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ROOM")
public class Room {
   private long id;
   private int numberOfGuests;
   private double price;
   private int breakfastIncluded;// (1 или 0)
   private int petsAllowed;// (1 или 0)
   private Date dateAvailableFrom;
   private Hotel hotel;




    @Id
    @SequenceGenerator(name="PR_SEQ",sequenceName ="PRODUCT_SEQ" ,allocationSize = 1)
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "PR_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }



    @Column(name = "NUMBEROFGUESTS")
    public int getNumberOfGuests() {
        return numberOfGuests;
    }



    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }


    @Column(name = "BREAKFASTINCLUDED")
    public int getBreakfastIncluded() {
        return breakfastIncluded;
    }


    @Column(name = "PETSALLOWED")
    public int getPetsAllowed() {
        return petsAllowed;
    }


    @Column(name = "DATEAVAILABLEFROM")
    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }



    @OneToOne(fetch = FetchType.LAZY,optional=false,cascade = CascadeType.ALL)
    @JoinColumn (name="HOTELID")

    public Hotel getHotel() {
        return hotel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakfastIncluded(int breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setPetsAllowed(int petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", hotel=" + hotel +
                '}';
    }
}
