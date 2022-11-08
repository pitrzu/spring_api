package com.pitrzuu.api.order;

import com.pitrzuu.api.item.IItemRepository;
import com.pitrzuu.api.item.pricing.IPricedItemRepository;
import com.pitrzuu.api.item.pricing.PriceID;
import com.pitrzuu.api.item.pricing.PricedItem;
import com.pitrzuu.api.order.detail.IDetailRepository;
import com.pitrzuu.api.order.detail.OrderDetail;
import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.order.dto.GetOrderDto;
import com.pitrzuu.api.order.status.EOrderStatus;
import com.pitrzuu.api.order.status.OrderStatus;
import com.pitrzuu.api.order.status.OrderStatusDto;
import com.pitrzuu.api.person.PeopleService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService{
    public OrderService( IOrderRepository ordersRepository,
                         PeopleService peopleService,
                         IDetailRepository detailsRepository,
                         IItemRepository itemsRepository,
                         IPricedItemRepository pricedItemRepository ){
        this.ordersRepository = ordersRepository;
        this.peopleService = peopleService;
        this.detailsRepository = detailsRepository;
        this.itemsRepository = itemsRepository;
        this.pricedItemRepository = pricedItemRepository;
    }

    private final IOrderRepository ordersRepository;
    private final IDetailRepository detailsRepository;
    private final IItemRepository itemsRepository;
    private final IPricedItemRepository pricedItemRepository;
    private final PeopleService peopleService;

    public GetOrderDto findOrderById( Long id ){
        return new GetOrderDto(ordersRepository.findOrderById(id).orElseThrow());
    }

    @Transactional
    @Modifying
    public GetOrderDto placeOrder( CreateOrderDto orderDto ){
        Order order = new Order();
        order.setAwaitedTime(orderDto.getAwaitedTime())
                .setCustomerComment(orderDto.getCustomerComment())
                .setPerson(peopleService.createPersonWithOrder(orderDto.getPerson(), order));
        Set<OrderDetail> ordered = orderDto.getOrdered().stream().map(detail -> {
                    PricedItem pricedItem = pricedItemRepository.findById(new PriceID(
                            itemsRepository.findById(detail.getItemId()).orElseThrow(),
                            detail.getSize()
                    )).orElseThrow();
                    return new OrderDetail()
                            .setOrder(order)
                            .setQuantity(detail.getQuantity())
                            .setPrice(pricedItem.getPrice())
                            .setItem(pricedItem);
                }
        ).collect(Collectors.toSet());
        ordersRepository.saveAndFlush(order);
        order.setOrderDetails(ordered);
        detailsRepository.saveAll(ordered);

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
