package com.pitrzuu.api.order;

import com.pitrzuu.api.order.detail.OrderDetailService;
import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.order.dto.GetOrderDto;
import com.pitrzuu.api.order.status.EOrderStatus;
import com.pitrzuu.api.order.status.OrderStatus;
import com.pitrzuu.api.order.status.OrderStatusDto;
import com.pitrzuu.api.person.PeopleService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OrderService{
    public OrderService( IOrderRepository ordersRepository,
                         PeopleService peopleService,
                         OrderDetailService orderDetailService ){
        this.ordersRepository = ordersRepository;
        this.peopleService = peopleService;
        this.orderDetailService = orderDetailService;
    }

    private final IOrderRepository ordersRepository;
    private final PeopleService peopleService;
    private final OrderDetailService orderDetailService;

    public GetOrderDto findOrderById( Long id ){
        Optional<Order> optional = ordersRepository.findOrderById(id);
        if(optional.isEmpty()) return new GetOrderDto();
        return new GetOrderDto(optional.get());
    }

    @Transactional
    @Modifying
    public GetOrderDto placeOrder( CreateOrderDto orderDto ){
        Order order = new Order();
        order.setAwaitedTime(orderDto.getAwaitedTime())
                .setCustomerComment(orderDto.getCustomerComment())
                .setOrderDetails(orderDetailService.createDetailsWithOrder(orderDto, order))
                .setPerson(peopleService.createPersonWithOrder(orderDto, order));
        ordersRepository.saveAndFlush(order);
        return new GetOrderDto(order);
    }

    @Transactional
    @Modifying
    public OrderStatusDto updateStatus(Long id, String status){
        Order order = ordersRepository.findById(id).orElseThrow();
        Set<OrderStatus> statuses = order.getOrderStatuses();
        OrderStatus orderStatus = new OrderStatus(order, EOrderStatus.valueOf(status));
        statuses.add(orderStatus);
        order.setOrderStatuses(statuses);
        ordersRepository.saveAndFlush(order);

        return new OrderStatusDto(order.getLatestStatus());
    }
}
