package com.pitrzuu.api.location.dto;

import java.io.Serializable;

public class LocationDto implements Serializable{
    public LocationDto(){}

    private String        email;
    private String        phone;
    private String    firstName;
    private String     lastName;
    private String         city;
    private String     postCode;
    private String       street;
    private String streetNumber;

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
    public String getCity(){
        return city;
    }
    public String getPostCode(){
        return postCode;
    }
    public String getStreet(){
        return street;
    }
    public String getStreetNumber(){
        return streetNumber;
    }

    public LocationDto setEmail( String email ){
        this.email = email;
        return this;
    }
    public LocationDto setPhone( String phone ){
        this.phone = phone;
        return this;
    }
    public LocationDto setFirstName( String firstName ){
        this.firstName = firstName;
        return this;
    }
    public LocationDto setLastName( String lastName ){
        this.lastName = lastName;
        return this;
    }
    public LocationDto setCity( String city ){
        this.city = city;
        return this;
    }
    public LocationDto setPostCode( String postCode ){
        this.postCode = postCode;
        return this;
    }
    public LocationDto setStreet( String street ){
        this.street = street;
        return this;
    }
    public LocationDto setStreetNumber( String streetNumber ){
        this.streetNumber = streetNumber;
        return this;
    }
}
