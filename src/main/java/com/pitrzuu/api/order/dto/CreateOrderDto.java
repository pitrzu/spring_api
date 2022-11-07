package com.pitrzuu.api.order.dto;

import com.pitrzuu.api.person.dto.PersonDto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

public class CreateOrderDto implements Serializable{
    private String customerComment;
    private Timestamp awaitedTime;
    private String promoCode;
    private Long userId;
    private PersonDto person;
    private Set<CreateDetailDto> ordered;

    public String getCustomerComment(){
        return customerComment;
    }
    public Timestamp getAwaitedTime(){
        return awaitedTime;
    }
    public String getPromoCode(){
        return promoCode;
    }
    public Long getUserId(){
        return userId;
    }
    public PersonDto getPerson(){
        return person;
    }
    public Set<CreateDetailDto> getOrdered(){
        return ordered;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreateOrderDto that )) return false;
        return Objects.equals(getCustomerComment(), that.getCustomerComment()) && Objects.equals(getAwaitedTime(), that.getAwaitedTime()) && Objects.equals(getPromoCode(), that.getPromoCode()) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getPerson(), that.getPerson()) && getOrdered().equals(that.getOrdered());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getCustomerComment(), getAwaitedTime(), getPromoCode(), getUserId(), getPerson(), getOrdered());
    }

    @Override
    public String toString(){
        return "CreateOrderDto{" + "customerComment='" + customerComment + '\'' + ", awaitedTime=" + awaitedTime + ", promoCode='" + promoCode + '\'' + ", userId=" + userId + ", person=" + person + ", ordered=" + ordered + '}';
    }
}
