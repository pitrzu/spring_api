package com.pitrzuu.api.location.dto;

import java.io.Serializable;
import java.util.Objects;

public class CreateLocationDTO implements Serializable{
    public CreateLocationDTO(){}
    public CreateLocationDTO( String firstName, String lastName, String email, String phone, String postCode, String city, String street, String streetNumber ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }
    public CreateLocationDTO( String firstName, String lastName, String email, String phone, String postCode, String city, String street, String streetNumber, Long userId ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.userId = userId;
    }

    private String    firstName;
    private String     lastName;
    private String        email;
    private String        phone;
    private String     postCode;
    private String         city;
    private String       street;
    private String streetNumber;
    private Long         userId;

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
    public Long getUserId(){
        return userId;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreateLocationDTO that )) return false;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getEmail().equals(that.getEmail()) && getPhone().equals(that.getPhone()) && getPostCode().equals(that.getPostCode()) && getCity().equals(that.getCity()) && getStreet().equals(that.getStreet()) && getStreetNumber().equals(that.getStreetNumber()) && Objects.equals(getUserId(), that.getUserId());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPhone(), getPostCode(), getCity(), getStreet(), getStreetNumber(), getUserId());
    }

    @Override
    public String toString(){
        return "CreateLocationDTO{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", postCode='" + postCode + '\'' + ", city='" + city + '\'' + ", street='" + street + '\'' + ", streetNumber='" + streetNumber + '\'' + ", userId=" + userId + '}';
    }
}
