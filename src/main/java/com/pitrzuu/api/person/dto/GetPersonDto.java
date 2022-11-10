package com.pitrzuu.api.person.dto;

import java.util.Objects;

public class GetPersonDto{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private String postCode;
    private String street;
    private String streetNumber;

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

    public GetPersonDto setFirstName( String firstName ){
        this.firstName = firstName;
        return this;
    }
    public GetPersonDto setLastName( String lastName ){
        this.lastName = lastName;
        return this;
    }
    public GetPersonDto setEmail( String email ){
        this.email = email;
        return this;
    }
    public GetPersonDto setPhone( String phone ){
        this.phone = phone;
        return this;
    }
    public GetPersonDto setCity( String city ){
        this.city = city;
        return this;
    }
    public GetPersonDto setPostCode( String postCode ){
        this.postCode = postCode;
        return this;
    }
    public GetPersonDto setStreet( String street ){
        this.street = street;
        return this;
    }
    public GetPersonDto setStreetNumber( String streetNumber ){
        this.streetNumber = streetNumber;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetPersonDto that )) return false;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getEmail().equals(that.getEmail()) && getPhone().equals(that.getPhone()) && getCity().equals(that.getCity()) && getPostCode().equals(that.getPostCode()) && getStreet().equals(that.getStreet()) && getStreetNumber().equals(that.getStreetNumber());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPhone(), getCity(), getPostCode(), getStreet(), getStreetNumber());
    }
}
