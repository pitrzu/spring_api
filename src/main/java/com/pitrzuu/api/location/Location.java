package com.pitrzuu.api.location;

import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.person.Person;
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

    @Column(name = "location_post-code", nullable = false, length = 5)
    private String postCode;

    @Column(name = "location_city", nullable = false)
    private String city;

    @Column(name = "location_street", nullable = false)
    private String street;

    @Column(name = "location_street-number", nullable = false)
    private String streetNumber;

    @OneToMany(mappedBy = "location")
    private Set<Person> people = new java.util.LinkedHashSet<>();

    @OneToMany(mappedBy = "location")
    private Set<Order> orders = new java.util.LinkedHashSet<>();

    public Long getId(){
        return id;
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
    public Set<Person> getPeople(){
        return people;
    }
    public Set<Order> getOrders(){
        return orders;
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
    public Location setPeople( Set<Person> people ){
        this.people = people;
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
        return getId().equals(location.getId()) && getPostCode().equals(location.getPostCode()) && getCity().equals(location.getCity()) && getStreet().equals(location.getStreet()) && getStreetNumber().equals(location.getStreetNumber()) && Objects.equals(getPeople(), location.getPeople());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getPostCode(), getCity(), getStreet(), getStreetNumber(), getPeople());
    }
}
