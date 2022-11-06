package com.pitrzuu.api.order.dto;

import com.pitrzuu.api.item.dto.GetItemDto;
import com.pitrzuu.api.location.LocationDto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class OrderDto implements Serializable{
    private String  customerComment;
    private Timestamp   awaitedTime;
    private Timestamp   createdTime;
    private Timestamp  promisedTime;
    private LocationDto locationDto;
    private Set<GetItemDto> ordered;
}
