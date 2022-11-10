package com.pitrzuu.api.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pitrzuu.api.detail.dto.GetDetailDto;
import com.pitrzuu.api.person.dto.GetPersonDto;
import com.pitrzuu.api.promocode.GetPromoCodeDto;
import com.pitrzuu.api.status.GetOrderStatusDto;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOrderDto{
   private Long id;
   private String comment;
   private Double totalPrice;
   private Timestamp creationTime;
   private Timestamp awaitedTime;
   private Timestamp promisedTime;
   private GetPromoCodeDto promoCode;
   private GetPersonDto person;
   private GetOrderStatusDto status;
   private Set<GetDetailDto> ordered;

    public Long getId(){
        return id;
    }
    public String getComment(){
        return comment;
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
    public GetOrderStatusDto getStatus(){
        return status;
    }
    public Set<GetDetailDto> getOrdered(){
        return ordered;
    }

    public GetOrderDto setId( Long id ){
        this.id = id;
        return this;
    }
    public GetOrderDto setComment( String comment ){
        this.comment = comment;
        return this;
    }
    public GetOrderDto setTotalPrice( Double totalPrice ){
        this.totalPrice = totalPrice;
        return this;
    }
    public GetOrderDto setCreationTime( Timestamp creationTime ){
        this.creationTime = creationTime;
        return this;
    }
    public GetOrderDto setAwaitedTime( Timestamp awaitedTime ){
        this.awaitedTime = awaitedTime;
        return this;
    }
    public GetOrderDto setPromisedTime( Timestamp promisedTime ){
        this.promisedTime = promisedTime;
        return this;
    }
    public GetOrderDto setPromoCode( GetPromoCodeDto promoCode ){
        this.promoCode = promoCode;
        return this;
    }
    public GetOrderDto setPerson( GetPersonDto person ){
        this.person = person;
        return this;
    }
    public GetOrderDto setStatus( GetOrderStatusDto status ){
        this.status = status;
        return this;
    }
    public GetOrderDto setOrdered( Set<GetDetailDto> ordered ){
        this.ordered = ordered;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetOrderDto that )) return false;
        return getId().equals(that.getId()) && Objects.equals(getComment(), that.getComment()) && getTotalPrice().equals(that.getTotalPrice()) && getCreationTime().equals(that.getCreationTime()) && Objects.equals(getAwaitedTime(), that.getAwaitedTime()) && Objects.equals(getPromisedTime(), that.getPromisedTime()) && Objects.equals(getPromoCode(), that.getPromoCode()) && getPerson().equals(that.getPerson()) && getStatus().equals(that.getStatus()) && getOrdered().equals(that.getOrdered());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getComment(), getTotalPrice(), getCreationTime(), getAwaitedTime(), getPromisedTime(), getPromoCode(), getPerson(), getStatus(), getOrdered());
    }
}
