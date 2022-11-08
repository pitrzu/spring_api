package com.pitrzuu.api.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.order.detail.dto.GetOrderDetailDto;
import com.pitrzuu.api.order.status.OrderStatusDto;
import com.pitrzuu.api.person.dto.GetPersonDto;
import com.pitrzuu.api.promocode.dto.GetPromoCodeDto;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetOrderDto{
    public GetOrderDto() {}
    public GetOrderDto( Order order ){
        this.id = order.getId();
        this.customerComment = order.getCustomerComment();
        this.totalPrice = order.getTotalPrice();
        this.creationTime = order.getCreationTime();
        this.awaitedTime = order.getAwaitedTime();
        this.promisedTime = order.getPromisedTime();
        this.promoCode = order.getPromoCode() == null ?
                null : new GetPromoCodeDto(order.getPromoCode());
        this.person = new GetPersonDto(order.getPerson());
        this.status = new OrderStatusDto(order.getLatestStatus());
        this.ordered = order.getOrderDetails()
                .stream()
                .map(GetOrderDetailDto::new)
                .collect(Collectors.toSet());
    }

    private Long id;
    private String customerComment;
    private Double totalPrice;
    private Timestamp creationTime;
    private Timestamp awaitedTime;
    private Timestamp promisedTime;
    private GetPromoCodeDto promoCode;
    private GetPersonDto person;
    private OrderStatusDto status;
    private Set<GetOrderDetailDto> ordered;

    public Long getId(){
        return id;
    }
    public String getCustomerComment(){
        return customerComment;
    }
    public Double getTotalPrice(){
        return totalPrice;
    }
    public Timestamp getCreationTime(){
        return creationTime;
    }
    public Timestamp getAwaitedTime(){
        return awaitedTime;
    }
    public Timestamp getPromisedTime(){
        return promisedTime;
    }
    public GetPromoCodeDto getPromoCode(){
        return promoCode;
    }
    public GetPersonDto getPerson(){
        return person;
    }
    public OrderStatusDto getStatus(){
        return status;
    }
    public Set<GetOrderDetailDto> getOrdered(){
        return ordered;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetOrderDto orderDto )) return false;
        return getId().equals(orderDto.getId()) && Objects.equals(getCustomerComment(), orderDto.getCustomerComment()) && getTotalPrice().equals(orderDto.getTotalPrice()) && getCreationTime().equals(orderDto.getCreationTime()) && Objects.equals(getAwaitedTime(), orderDto.getAwaitedTime()) && Objects.equals(getPromisedTime(), orderDto.getPromisedTime()) && Objects.equals(getPromoCode(), orderDto.getPromoCode()) && getPerson().equals(orderDto.getPerson()) && getStatus().equals(orderDto.getStatus()) && getOrdered().equals(orderDto.getOrdered());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getCustomerComment(), getTotalPrice(), getCreationTime(), getAwaitedTime(), getPromisedTime(), getPromoCode(), getPerson(), getStatus(), getOrdered());
    }
}
