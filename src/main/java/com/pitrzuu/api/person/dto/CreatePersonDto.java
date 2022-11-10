package com.pitrzuu.api.person.dto;

import com.pitrzuu.api.location.dto.CreateLocationDto;
import com.pitrzuu.api.user.dto.UserDto;

import java.util.Objects;

public class CreatePersonDto{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Long userId;
    private UserDto user;
    private Long locationId;
    private CreateLocationDto location;

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
    public Long getLocationId(){
        return locationId;
    }
    public Long getUserId(){
        return userId;
    }
    public UserDto getUser(){
        return user;
    }
    public CreateLocationDto getLocation(){
        return location;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreatePersonDto that )) return false;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getEmail().equals(that.getEmail()) && getPhone().equals(that.getPhone()) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getLocationId(), that.getLocationId()) && Objects.equals(getLocation(), that.getLocation());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPhone(), getUserId(), getUser(), getLocationId(), getLocation());
    }
}
