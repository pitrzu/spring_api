package com.pitrzuu.api.location;

import com.pitrzuu.api.person.Person;
import com.pitrzuu.api.person.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LocationService{
    public LocationService( ILocationRepository locationsRepository ){this.locationsRepository = locationsRepository;}

    private final ILocationRepository locationsRepository;

    public Location creteLocationWithPerson( PersonDto personDto, Person person ){
        Location location = new Location()
                .setPostCode(personDto.getPostCode())
                .setCity(personDto.getCity())
                .setStreet(personDto.getStreet())
                .setStreetNumber(personDto.getStreetNumber())
                .setPeople(Set.of(person));
        locationsRepository.saveAndFlush(location);

        return location;
    }
}
