package com.pitrzuu.api.person;

import com.pitrzuu.api.location.LocationService;
import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.person.dto.PersonDto;
import com.pitrzuu.api.user.IUserRepository;
import com.pitrzuu.api.user.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PeopleService{
    public PeopleService( IPeopleRepository peopleRepository,
                          IUserRepository usersRepository,
                          LocationService locationsService ){
        this.peopleRepository = peopleRepository;
        this.usersRepository = usersRepository;
        this.locationsService = locationsService;
    }

    private final IPeopleRepository peopleRepository;
    private final IUserRepository usersRepository;
    private final LocationService locationsService;

    public Person createPersonWithOrder( PersonDto personDto, Order order ){
        if(personDto.getUserId() != null)
            return usersRepository
                    .findById(personDto.getUserId())
                    .map(User::getPerson)
                    .orElseThrow();
        Person person = new Person()
                .setEmail(personDto.getEmail())
                .setPhone(personDto.getPhone())
                .setFirstName(personDto.getFirstName())
                .setLastName(personDto.getLastName())
                .setOrders(Set.of(order));
        person.setLocation(locationsService.creteLocationWithPerson(personDto, person));
        peopleRepository.saveAndFlush(person);

        return person;
    }
}
