package com.pitrzuu.api.person;

import com.pitrzuu.api.location.Location;
import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.user.User;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "people", uniqueConstraints = {
        @UniqueConstraint(name = "unq_contact", columnNames = {"person_email", "person_phone"})
})
public class Person{
    public Person(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "person_firstname", nullable = false, length = 32)
    private String firstName;

    @Column(name = "person_lastname", nullable = false, length = 32)
    private String lastName;

    @Column(name = "person_email", nullable = false, length = 64)
    private String email;

    @Column(name = "person_phone", nullable = false, length = 64)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private Set<Order> orders = new java.util.LinkedHashSet<>();

    public Long getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public Location getLocation(){
        return location;
    }
    public User getUser(){
        return user;
    }
    public Set<Order> getOrders() { return orders; }

    public Person setFirstName( String firstName ){
        this.firstName = firstName;
        return this;
    }
    public Person setLastName( String lastName ){
        this.lastName = lastName;
        return this;
    }
    public Person setEmail( String email ){
        this.email = email;
        return this;
    }
    public Person setPhone( String phone ){
        this.phone = phone;
        return this;
    }
    public Person setLocation( Location location ){
        this.location = location;
        return this;
    }
    public Person setUser( User user ){
        this.user = user;
        return this;
    }
    public Person setOrders( Set<Order> orders ){
        this.orders = orders;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof Person person )) return false;
        return getId().equals(person.getId()) && getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName()) && getEmail().equals(person.getEmail()) && getPhone().equals(person.getPhone()) && getLocation().equals(person.getLocation()) && Objects.equals(getUser(), person.getUser());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(),
                getFirstName(),
                getLastName(),
                getEmail(),
                getPhone(),
                getLocation(),
                getUser());
    }
}
