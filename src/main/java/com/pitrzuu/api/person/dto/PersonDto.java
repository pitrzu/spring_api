package com.pitrzuu.api.person.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.Objects;

public class PersonDto implements Serializable{

    private Long userId;

    @NotBlank
    protected String firstName;

    @NotBlank
    protected String lastName;

    @Email
    @NotBlank
    protected String email;

    @NotBlank
    @Pattern(regexp = "[0-9]{9}")
    protected String phone;

    @NotBlank
    @Pattern(regexp = "[1-9][0-9]{4}")
    protected String postCode;

    @NotBlank
    protected String city;

    @NotBlank
    protected String street;

    @NotBlank
    @Pattern(regexp = "[0-9]{1,6}")
    protected String streetNumber;

    public Long getUserId(){
        return userId;
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
