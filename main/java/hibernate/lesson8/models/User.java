package hibernate.lesson8.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER_")
public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;


    @Id
    @Column(name = "USER_ID")
    public long getId() {
        return id;
    }

    @Column(name = "USERNAME")
    public String getUserName() {
        return userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }


    @Column(name = "USERTYPE")
    public UserType getUserType() {
        return userType;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userOrdered", cascade = CascadeType.ALL)
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", userType=" + userType +
                ", orders=" + orders +
                '}';
    }
}

