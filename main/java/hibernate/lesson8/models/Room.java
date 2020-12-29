package hibernate.lesson8.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ROOM")
public class Room {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;

    @Id
    // @SequenceGenerator(name="PR_SEQ",sequenceName ="PRODUCT_SEQ" ,allocationSize = 1)
    // @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "PR_SEQ")
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
    public boolean getBreakfastIncluded() {
        return breakfastIncluded;
    }


    @Column(name = "PETSALLOWED")
    public boolean getPetsAllowed() {
        return petsAllowed;
    }

    @Column(name = "DATEAVAILABLEFROM")
    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }


    @OneToOne(fetch = FetchType.LAZY,mappedBy = "room", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    public Order getOrder() {
        return order;
    }

    private Order order;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "HOTEL_ID")
    public Hotel getHotel() {
        return hotel;
    }

    private Hotel hotel;


    public void setId(long id) {
        this.id = id;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }


    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setOrder(Order order) {
        this.order = order;
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
