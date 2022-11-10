package com.pitrzuu.api.status;

import org.springframework.stereotype.Component;

@Component
public class StatusMapper{
    public GetOrderStatusDto createDto( OrderStatus status ){
        return new GetOrderStatusDto()
                .setStatus(status.getOrderStatus().name())
                .setTime(status.getCreationTime());
    }
}
