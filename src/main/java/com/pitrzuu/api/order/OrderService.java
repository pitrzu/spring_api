package com.pitrzuu.api.order;

import com.pitrzuu.api.item.Item;
import com.pitrzuu.api.item.dto.IItemRepository;
import com.pitrzuu.api.item.pricing.IPricedItemRepository;
import com.pitrzuu.api.item.pricing.PriceID;
import com.pitrzuu.api.item.pricing.PricedItem;
import com.pitrzuu.api.location.ILocationRepository;
import com.pitrzuu.api.location.Location;
import com.pitrzuu.api.order.detail.IDetailRepository;
import com.pitrzuu.api.order.detail.OrderDetail;
import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.order.dto.OrderDto;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService{
    public OrderService( IPricedItemRepository pricedItemRepository, IItemRepository itemsRepository, ILocationRepository locationsRepository, IOrderRepository ordersRepository, IDetailRepository detailsRepository ){
        this.pricedItemRepository = pricedItemRepository;
        this.itemsRepository = itemsRepository;
        this.locationsRepository = locationsRepository;
        this.ordersRepository = ordersRepository;
        this.detailsRepository = detailsRepository;
    }

    private final IPricedItemRepository pricedItemRepository;
    private final IItemRepository itemsRepository;
    private final ILocationRepository locationsRepository;
    private final IOrderRepository ordersRepository;
    private final IDetailRepository detailsRepository;

    Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderDto findOrderById( Long id ){
        Optional<Order> optional = ordersRepository.findOrderById(id);
        if(optional.isEmpty()) return new OrderDto();
        return new OrderDto();
    }

    @Transactional
    @Modifying
    public OrderDto placeOrder( CreateOrderDto orderDto ){
        System.out.println(orderDto.toString());
        Order order = new Order();
        Set<OrderDetail> detailSet = orderDto.getOrdered().stream().map(
                itemDto -> {
                    Item item = itemsRepository.findById(itemDto.getId()).get();
                    PricedItem pItem = pricedItemRepository.findById(new PriceID(item, itemDto.getSize())).get();
                    return new OrderDetail()
                            .setOrder(order)
                            .setItem(pItem)
                            .setQuantity(itemDto.getQuantity())
                            .setPrice(pItem.getPrice());
                }
        ).collect(Collectors.toSet());
        Location location = new Location()
                .setCity(orderDto.getLocationDto().getCity())
                .setPostCode(orderDto.getLocationDto().getPostCode())
                .setStreet(orderDto.getLocationDto().getStreet())
                .setStreetNumber(orderDto.getLocationDto().getStreetNumber());
        order.setCustomerComment(orderDto.getCustomerComment()).setOrderDetails(detailSet).setLocation(location);
        locationsRepository.saveAndFlush(location);
        ordersRepository.saveAndFlush(order);
        detailsRepository.saveAll(detailSet);
        return new OrderDto();
    }
}
