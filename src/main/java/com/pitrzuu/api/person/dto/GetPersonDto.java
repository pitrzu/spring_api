package com.pitrzuu.api.person.dto;

import com.pitrzuu.api.person.Person;
import org.jetbrains.annotations.NotNull;

public class GetPersonDto extends PersonDto{
    public GetPersonDto() {}
    public GetPersonDto( @NotNull Person person ){
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.phone = person.getPhone();
        this.email = person.getEmail();
        this.city = person.getLocation().getCity();
        this.postCode = person.getLocation().getPostCode();
        this.street = person.getLocation().getStreet();
        this.streetNumber = person.getLocation().getStreetNumber();
    }

    private Long id;

    public Long getId(){
        return id;
    }
}
