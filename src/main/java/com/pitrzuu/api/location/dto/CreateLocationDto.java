package com.pitrzuu.api.location.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

public class CreateLocationDto{

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String city;

    @NotBlank
    @Pattern(regexp = "\\d{5}")
    private String postCode;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String street;

    @NotBlank
    @Pattern(regexp = "\\d*")
    private String streetNumber;

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

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreateLocationDto that )) return false;
        return getCity().equals(that.getCity()) && getPostCode().equals(that.getPostCode()) && getStreet().equals(that.getStreet()) && getStreetNumber().equals(that.getStreetNumber());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getCity(), getPostCode(), getStreet(), getStreetNumber());
    }
}
