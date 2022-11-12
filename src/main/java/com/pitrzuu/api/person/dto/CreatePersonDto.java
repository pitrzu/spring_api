package com.pitrzuu.api.person.dto;

import com.pitrzuu.api.location.dto.CreateLocationDto;
import com.pitrzuu.api.user.dto.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;
import java.util.Optional;

public class CreatePersonDto{

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{9}")
    private String phone;

    @Valid
    private UserDto user;

    @Min(1)
    private Long locationId;

    @Valid
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
    public Optional<Long> getLocationId(){
        return Optional.ofNullable(locationId);
    }
    public Optional<UserDto> getUser(){
        return Optional.ofNullable(user);
    }
    public Optional<CreateLocationDto> getLocation(){
        return Optional.ofNullable(location);
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreatePersonDto that )) return false;
        return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getEmail().equals(that.getEmail()) && getPhone().equals(that.getPhone()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getLocationId(), that.getLocationId()) && Objects.equals(getLocation(), that.getLocation());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPhone(), getUser(), getLocationId(), getLocation());
    }
}
