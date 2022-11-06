package com.pitrzuu.api.order.dto;

import com.pitrzuu.api.IValidateDto;
import com.pitrzuu.api.item.dto.ItemDto;
import com.pitrzuu.api.location.LocationDto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class CreateOrderDto implements Serializable, IValidateDto{
    private String  customerComment;
    private Timestamp   awaitedTime;
    private Timestamp  promisedTime;
    private LocationDto locationDto;
    private Long         locationId;
    private Set<ItemDto>    ordered;

    public String getCustomerComment(){
        return customerComment;
    }
    public Timestamp getAwaitedTime(){
        return awaitedTime;
    }
    public Timestamp getPromisedTime(){
        return promisedTime;
    }
    public LocationDto getLocationDto(){
        return locationDto;
    }
    public Long getLocationId(){
        return locationId;
    }
    public Set<ItemDto> getOrdered(){
        return ordered;
    }

    @Override
    public boolean isValid(){
        return false;
    }

    @Override
    public String toString(){
        return "CreateOrderDto{" + "customerComment='" + customerComment + '\'' + ", awaitedTime=" + awaitedTime + ", promisedTime=" + promisedTime + ", locationDto=" + locationDto + ", locationId=" + locationId + ", ordered=" + ordered + '}';
    }
}
