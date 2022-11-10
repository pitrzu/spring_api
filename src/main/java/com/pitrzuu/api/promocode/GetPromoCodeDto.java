package com.pitrzuu.api.promocode;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetPromoCodeDto{
    private String promoCode;
    private Double amount;
    private Double percentage;
    private Timestamp expirationDate;

    public String getPromoCode(){
        return promoCode;
    }

    public Double getAmount(){
        return amount;
    }

    public Double getPercentage(){
        return percentage;
    }

    public Timestamp getExpirationDate(){
        return expirationDate;
    }

    public GetPromoCodeDto setPromoCode( String promoCode ){
        this.promoCode = promoCode;
        return this;
    }

    public GetPromoCodeDto setAmount( Double amount ){
        this.amount = amount;
        return this;
    }

    public GetPromoCodeDto setPercentage( Double percentage ){
        this.percentage = percentage;
        return this;
    }

    public GetPromoCodeDto setExpirationDate( Timestamp expirationDate ){
        this.expirationDate = expirationDate;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetPromoCodeDto that )) return false;
        return getPromoCode().equals(that.getPromoCode()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getPercentage(), that.getPercentage()) && getExpirationDate().equals(that.getExpirationDate());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getPromoCode(), getAmount(), getPercentage(), getExpirationDate());
    }
}
