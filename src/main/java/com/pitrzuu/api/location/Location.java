package com.pitrzuu.api.location;

import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.user.User;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location{
    public Location(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private Long id;

    @Column(name = "location_first-name", nullable = false)
    private String firstName;

    @Column(name = "location_last-name", nullable = false)
    private String lastName;

    @Column(name = "location_email", nullable = false, length = 64)
    private String email;

    @Column(name = "location_phone", nullable = false, length = 9)
    private String phone;

    @Column(name = "location_post-code", nullable = false, length = 5)
    private String postCode;

    @Column(name = "location_city", nullable = false)
    private String city;

    @Column(name = "location_street", nullable = false)
    private String street;

    @Column(name = "location_street-number", nullable = false)
    private String streetNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "location")
    private Set<Order> orders;

    public Long getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPostCode(){
        return postCode;
    }
    public String getCity(){
        return city;
    }
    public String getStreet(){
        return street;
    }
    public String getStreetNumber(){
        return streetNumber;
    }
    public User getUser(){
        return user;
    }
    public Set<Order> getOrders(){
        return orders;
    }

    public Location setEmail( String email ){
        this.email = email;
        return this;
    }
    public Location setPhone( String phone ){
        this.phone = phone;
        return this;
    }
    public Location setFirstName( String firstName ){
        this.firstName = firstName;
        return this;
    }
    public Location setLastName( String lastName ){
        this.lastName = lastName;
        return this;
    }
    public Location setPostCode( String postCode ){
        this.postCode = postCode;
        return this;
    }
    public Location setCity( String city ){
        this.city = city;
        return this;
    }
    public Location setStreet( String street ){
        this.street = street;
        return this;
    }
    public Location setStreetNumber( String streetNumber ){
        this.streetNumber = streetNumber;
        return this;
    }
    public Location setUser( User user ){
        this.user = user;
        return this;
    }
    public Location setOrders( Set<Order> orders ){
        this.orders = orders;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof Location location )) return false;
        return getId().equals(location.getId()) && getFirstName().equals(location.getFirstName()) && getLastName().equals(location.getLastName()) && getEmail().equals(location.getEmail()) && getPhone().equals(location.getPhone()) && getPostCode().equals(location.getPostCode()) && getCity().equals(location.getCity()) && getStreet().equals(location.getStreet()) && getStreetNumber().equals(location.getStreetNumber()) && Objects.equals(getUser(), location.getUser());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPhone(), getPostCode(), getCity(), getStreet(), getStreetNumber(), getUser());
    }
}
