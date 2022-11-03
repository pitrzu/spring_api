package com.pitrzuu.api.location;

import com.pitrzuu.api.order.delivery.Delivery;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "locations")
public class Location {
    public Location() {}
    public Location(Delivery delivery, String email, String phone, String country, Voivodeship voivodeship, String city, String postCode, String street, String streetNumber) {
        this.delivery = delivery;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.voivodeship = voivodeship;
        this.city = city;
        this.postCode = postCode;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    @Id
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    @Column(name = "location_email", nullable = false, unique = true)
    private String email;

    @Column(name = "location_phone-number", nullable = false, unique = true, length = 9)
    private String phone;

    @Column(name = "location_conutry", nullable = false, length = 2)
    private String country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "voivodeship_id", nullable = false)
    private Voivodeship voivodeship;

    @Column(name = "location_city", nullable = false, length = 32)
    private String city;

    @Column(name = "location_post-code", nullable = false, length = 5)
    private String postCode;

    @Column(name = "location_street", nullable = false, length = 32)
    private String street;

    @Column(name = "location_street-number", nullable = false, length = 12)
    private String streetNumber;

    public Delivery getDelivery() {
        return delivery;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getCountry() {
        return country;
    }
    public Voivodeship getVoivodeship() {
        return voivodeship;
    }
    public String getCity() {
        return city;
    }
    public String getPostCode() {
        return postCode;
    }
    public String getStreet() {
        return street;
    }
    public String getStreetNumber() {
        return streetNumber;
    }

    public Location setDelivery(Delivery delivery) {
        this.delivery = delivery;
        return this;
    }
    public Location setEmail(String email) {
        this.email = email;
        return this;
    }
    public Location setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public Location setCountry(String country) {
        this.country = country;
        return this;
    }
    public Location setVoivodeship(Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
        return this;
    }
    public Location setCity(String city) {
        this.city = city;
        return this;
    }
    public Location setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }
    public Location setStreet(String street) {
        this.street = street;
        return this;
    }
    public Location setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return getDelivery().equals(location.getDelivery()) && getEmail().equals(location.getEmail()) && getPhone().equals(location.getPhone()) && getCountry().equals(location.getCountry()) && getVoivodeship().equals(location.getVoivodeship()) && getCity().equals(location.getCity()) && getPostCode().equals(location.getPostCode()) && getStreet().equals(location.getStreet()) && getStreetNumber().equals(location.getStreetNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDelivery(), getEmail(), getPhone(), getCountry(), getVoivodeship(), getCity(), getPostCode(), getStreet(), getStreetNumber());
    }
}
