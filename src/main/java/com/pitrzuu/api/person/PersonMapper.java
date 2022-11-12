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
    public PersonMapper( ILocationRepository locationsRepository,
                         UserMapper userMapper ){
        this.locationsRepository = locationsRepository;
        this.userMapper = userMapper;
    }

    private final ILocationRepository locationsRepository;
    private final UserMapper userMapper;

    public Person createEntity( CreatePersonDto person ){
        return new Person()
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName())
                .setEmail(person.getEmail())
                .setPhone(person.getPhone())
                .setLocation(person.getLocationId().isPresent() ?
                        locationsRepository.findById(person.getLocationId().get()).orElseThrow(() ->
                                new EntityNotFoundException(String.format("Location with id: %d, not found!", person.getLocationId().get()))) :
                        LocationMapper.createEntity(person.getLocation().orElseThrow(() ->
                                new IllegalArgumentException("You have to provide a location!")
                        ))
                ).setUser(person.getUser().isPresent() ?
                    userMapper.createEntity(person.getUser().get()) : null);
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
