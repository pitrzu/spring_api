package com.pitrzuu.api.order.detail;

import com.pitrzuu.api.item.IItemRepository;
import com.pitrzuu.api.item.pricing.IPricedItemRepository;
import com.pitrzuu.api.item.pricing.PriceID;
import com.pitrzuu.api.item.pricing.PricedItem;
import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.order.dto.CreateOrderDto;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderDetailService{
    public OrderDetailService( IPricedItemRepository pricedItemRepository,
                               IItemRepository itemsRepository,
                               IDetailRepository detailsRepository ){
        this.pricedItemRepository = pricedItemRepository;
        this.itemsRepository = itemsRepository;
        this.detailsRepository = detailsRepository;
    }

    private final IDetailRepository detailsRepository;
    private final IItemRepository itemsRepository;
    private final IPricedItemRepository pricedItemRepository;

    public Set<OrderDetail> createDetailsWithOrder( CreateOrderDto orderDto, Order order ){
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
        detailsRepository.saveAll(ordered);
        return ordered;
    }
}
