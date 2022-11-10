package com.pitrzuu.api.pricing;

import com.pitrzuu.api.detail.OrderDetail;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper{
    public static GetPriceDto createDto( OrderDetail detail ){
        return new GetPriceDto()
                .setPrice(detail.getPrice())
                .setQuantity(detail.getQuantity())
                .setSize(detail.getPricedItem().getSize().name());
    }
}
