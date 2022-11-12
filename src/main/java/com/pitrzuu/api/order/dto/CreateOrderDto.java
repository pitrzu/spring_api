package com.pitrzuu.api.order.dto;

import com.pitrzuu.api.detail.dto.CreateDetailDto;
import com.pitrzuu.api.person.dto.CreatePersonDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.UniqueElements;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class CreateOrderDto{
    private String customerComment;
    private Timestamp awaitedTime;

    @Min(1)
    private Long personId;

    @Valid
    private CreatePersonDto person;

    @UniqueElements
    private Set<@Valid CreateDetailDto> ordered;

    @Pattern(regexp = "[A-Z]+")
    private String promoCode;

    public String getCustomerComment(){
        return customerComment;
    }
    public Timestamp getAwaitedTime(){
        return awaitedTime;
    }
    public Optional<Long> getPersonId(){
        return Optional.ofNullable(personId);
    }
    public Optional<CreatePersonDto> getPerson(){
        return Optional.ofNullable(person);
    }
    public Set<CreateDetailDto> getOrdered(){
        return ordered;
    }
    public Optional<String> getPromoCode(){
        return Optional.ofNullable(promoCode);
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreateOrderDto that )) return false;
        return Objects.equals(getCustomerComment(), that.getCustomerComment()) && Objects.equals(getAwaitedTime(), that.getAwaitedTime()) && Objects.equals(getPersonId(), that.getPersonId()) && Objects.equals(getPerson(), that.getPerson()) && getOrdered().equals(that.getOrdered()) && Objects.equals(getPromoCode(), that.getPromoCode());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getCustomerComment(), getAwaitedTime(), getPersonId(), getPerson(), getOrdered(), getPromoCode());
    }
}
