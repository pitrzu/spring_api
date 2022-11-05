package com.pitrzuu.api.order.dto;

import com.pitrzuu.api.item.pricing.ESize;
import com.pitrzuu.api.location.dto.CreateLocationDTO;

import java.io.Serializable;
import java.util.Objects;

public class CreateOrderDTO implements Serializable{
    private String        customerComment;
    private Iterable<OrderItemDTO>  items;
    private Long               locationId;
    private CreateLocationDTO locationDTO;

    public String getCustomerComment(){
        return customerComment;
    }
    public Iterable<OrderItemDTO> getItems(){
        return items;
    }
    public Long getLocationId(){
        return locationId;
    }
    public CreateLocationDTO getLocationDTO(){
        return locationDTO;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreateOrderDTO that )) return false;
        return getCustomerComment().equals(that.getCustomerComment()) && getItems().equals(that.getItems()) && Objects.equals(getLocationId(), that.getLocationId()) && Objects.equals(getLocationDTO(), that.getLocationDTO());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getCustomerComment(), getItems(), getLocationId(), getLocationDTO());
    }
}

class OrderItemDTO implements Serializable{
    private Integer id;
    private ESize size;
    private Integer quantity;
}
