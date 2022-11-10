package com.pitrzuu.api.person;

import com.pitrzuu.api.location.ILocationRepository;
import com.pitrzuu.api.location.LocationMapper;
import com.pitrzuu.api.person.dto.CreatePersonDto;
import com.pitrzuu.api.person.dto.GetPersonDto;
import com.pitrzuu.api.user.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper{
    public PersonMapper( ILocationRepository locationsRepository){
        this.locationsRepository = locationsRepository;
    }

    private final ILocationRepository locationsRepository;

    public Person createEntity( CreatePersonDto person ){
        return new Person()
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName())
                .setEmail(person.getEmail())
                .setPhone(person.getPhone())
                .setLocation(person.getLocationId() != null ?
                        locationsRepository.findById(person.getLocationId()).orElseThrow(EntityNotFoundException::new) :
                        LocationMapper.createEntity(person.getLocation())
                ).setUser(person.getUserId() != null ? UserMapper.createEntity(person.getUser()) : null);
    }

    public GetPersonDto createDto( Person person ){
        return new GetPersonDto()
                .setCity(person.getLocation().getCity())
                .setPostCode(person.getLocation().getPostCode())
                .setStreet(person.getLocation().getStreet())
                .setStreetNumber(person.getLocation().getStreetNumber())
                .setEmail(person.getEmail())
                .setPhone(person.getPhone())
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName());
    }
}
