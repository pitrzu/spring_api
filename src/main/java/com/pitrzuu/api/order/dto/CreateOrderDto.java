package com.pitrzuu.api.order.dto;

import com.pitrzuu.api.order.detail.dto.CreateDetailDto;
import com.pitrzuu.api.person.dto.PersonDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

public class CreateOrderDto implements Serializable{
    private String customerComment;
    private Timestamp awaitedTime;
    private String promoCode;

    @Valid
    private PersonDto person;

    @NotEmpty
    private Collection<@Valid CreateDetailDto> ordered;

    public String getCustomerComment(){
        return customerComment;
    }
    public Timestamp getAwaitedTime(){
        return awaitedTime;
    }
    public String getPromoCode(){
        return promoCode;
    }
    public PersonDto getPerson(){
        return person;
    }
    public Collection<CreateDetailDto> getOrdered(){
        return ordered;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreateOrderDto that )) return false;
        return Objects.equals(getCustomerComment(), that.getCustomerComment()) && Objects.equals(getAwaitedTime(), that.getAwaitedTime()) && Objects.equals(getPromoCode(), that.getPromoCode()) && Objects.equals(getPerson(), that.getPerson()) && getOrdered().equals(that.getOrdered());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getCustomerComment(), getAwaitedTime(), getPromoCode(), getPerson(), getOrdered());
    }

    @Override
    public String toString(){
        return "CreateOrderDto{" + "customerComment='" + customerComment + '\'' + ", awaitedTime=" + awaitedTime + ", promoCode='" + promoCode + '\'' + ", person=" + person + ", ordered=" + ordered + '}';
    }
}
