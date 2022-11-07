package com.pitrzuu.api.person.dto;

import java.io.Serializable;
import java.util.Objects;

public class PersonDto implements Serializable{
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;
    protected String postCode;
    protected String city;
    protected String street;
    protected String streetNumber;

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

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof PersonDto that )) return false;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getEmail().equals(that.getEmail()) && getPhone().equals(that.getPhone()) && getPostCode().equals(that.getPostCode()) && getCity().equals(that.getCity()) && getStreet().equals(that.getStreet()) && getStreetNumber().equals(that.getStreetNumber());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPhone(), getPostCode(), getCity(), getStreet(), getStreetNumber());
    }

    @Override
    public String toString(){
        return "CreatePersonDto{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", postCode='" + postCode + '\'' + ", city='" + city + '\'' + ", street='" + street + '\'' + ", streetNumber='" + streetNumber + '\'' + '}';
    }
}
