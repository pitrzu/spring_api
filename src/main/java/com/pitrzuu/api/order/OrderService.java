package com.pitrzuu.api.order;

import com.pitrzuu.api.detail.IDetailRepository;
import com.pitrzuu.api.location.ILocationRepository;
import com.pitrzuu.api.person.IPersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class OrderService{
    public OrderService( IOrderRepository ordersRepository,
                         IPersonRepository peopleRepository,
                         ILocationRepository locationsRepository,
                         IDetailRepository detailsRepository ){
        this.ordersRepository = ordersRepository;
        this.peopleRepository = peopleRepository;
        this.locationsRepository = locationsRepository;
        this.detailsRepository = detailsRepository;
    }

    private final IOrderRepository ordersRepository;
    private final IPersonRepository peopleRepository;
    private final ILocationRepository locationsRepository;
    private final IDetailRepository detailsRepository;

    public Optional<Order> findOrderById(Long id){
        return ordersRepository.findById(id);
    }

    public Collection<Order> findAll(){
        return ordersRepository.findAll();
    }

    @Transactional
    @Modifying
    public Order create( Order order ){
        locationsRepository.saveAndFlush(order.getPerson().getLocation());
        peopleRepository.saveAndFlush(order.getPerson());
        ordersRepository.saveAndFlush(order);
        detailsRepository.saveAll(order.getOrderDetails());

        return order;
    }
}
