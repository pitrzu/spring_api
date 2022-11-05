package com.pitrzuu.api.order.dto;

import com.pitrzuu.api.location.dto.CreateLocationDTO;
import com.pitrzuu.api.order.Order;

import java.io.Serializable;
import java.util.Objects;

public class GetOrderDTO implements Serializable{
    public GetOrderDTO( Order order){
        this.customerComment = order.getCustomerComment();
        this.locationDTO = new CreateLocationDTO(
                order.getLocation().getFirstName(),
                order.getLocation().getLastName(),
                order.getLocation().getEmail(),
                order.getLocation().getPhone(),
                order.getLocation().getPostCode(),
                order.getLocation().getCity(),
                order.getLocation().getStreet(),
                order.getLocation().getStreetNumber()
        );
    }

    private String customerComment;
    private CreateLocationDTO locationDTO;

    public String getCustomerComment(){
        return customerComment;
    }

    public GetOrderDTO setCustomerComment( String customerComment ){
        this.customerComment = customerComment;
        return this;
    }

    public CreateLocationDTO getLocationDTO(){
        return locationDTO;
    }

    public GetOrderDTO setLocationDTO( CreateLocationDTO locationDTO ){
        this.locationDTO = locationDTO;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetOrderDTO that )) return false;
        return getCustomerComment().equals(that.getCustomerComment()) && getLocationDTO().equals(that.getLocationDTO());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getCustomerComment(), getLocationDTO());
    }


    @Override
    public String toString(){
        return "GetOrderDTO{" + "customerComment='" + customerComment + '\'' + ", locationDTO=" + locationDTO + '}';
    }
}
