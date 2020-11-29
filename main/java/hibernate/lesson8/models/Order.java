package hibernate.lesson8.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ORDER_")
public class Order {
    @Id
    @Column(name = "ID")
    private long id;


    @OneToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ROOM_ID")
    private Room room;


    @Column(name = "DATEFROM")
    private Date dateFrom;

    @Column(name = "DATETO")
    private Date dateTo;

    @Column(name = "MONEYPAID")
    private double moneyPaid;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User userOrdered;


    public void setId(long id) {
        this.id = id;
    }

    public void setUserOrdered(User userOrdered) {
        this.userOrdered = userOrdered;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }


    public long getId() {
        return id;
    }

    public User getUserOrdered() {
        return userOrdered;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                //        ", userOrdered=" + userOrdered +
                ", room=" + room +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", moneyPaid=" + moneyPaid +
                //          ", userOrdered=" + userOrdered +
                '}';
    }
}
