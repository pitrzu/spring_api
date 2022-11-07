package com.pitrzuu.api.person;

import com.pitrzuu.api.location.ILocationRepository;
import com.pitrzuu.api.location.Location;
import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.person.dto.PersonDto;
import com.pitrzuu.api.user.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PeopleService{
    public PeopleService( IPeopleRepository peopleRepository,
                          IUserRepository usersRepository,
                          ILocationRepository locationsRepository ){
        this.peopleRepository = peopleRepository;
        this.usersRepository = usersRepository;
        this.locationsRepository = locationsRepository;
    }

    private final IPeopleRepository peopleRepository;
    private final ILocationRepository locationsRepository;
    private final IUserRepository usersRepository;

    public Person createPersonWithOrder( CreateOrderDto orderDto, Order order ){
        if(orderDto.getUserId() != null && usersRepository.findById(orderDto.getUserId()).isPresent())
            return usersRepository.findById(orderDto.getUserId()).get().getPerson();
        PersonDto personDto = orderDto.getPerson();
        Person person = new Person()
                .setEmail(personDto.getEmail())
                .setPhone(personDto.getPhone())
                .setFirstName(personDto.getFirstName())
                .setLastName(personDto.getLastName())
                .setOrders(Set.of(order));
        Location location = new Location()
                .setPostCode(personDto.getPostCode())
                .setCity(personDto.getCity())
                .setStreet(personDto.getStreet())
                .setStreetNumber(personDto.getStreetNumber())
                .setPeople(Set.of(person));
        person.setLocation(location);
        locationsRepository.saveAndFlush(location);
        peopleRepository.saveAndFlush(person);

        return person;
    }
}
