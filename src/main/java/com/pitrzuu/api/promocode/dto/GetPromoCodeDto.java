package com.pitrzuu.api.promocode.dto;

import com.pitrzuu.api.promocode.PromoCode;

import java.util.Objects;

public class GetPromoCodeDto{
    public GetPromoCodeDto( PromoCode promoCode ){
        this.id = promoCode.getId();
        this.code = promoCode.getName();
        this.amount = promoCode.getDiscountAmount();
        this.percentage = promoCode.getDiscountPercentage();
    }

    private final Long id;
    private final String code;
    private final Double amount;
    private final Double percentage;

    public Long getId(){
        return id;
    }

    public String getCode(){
        return code;
    }

    public Double getAmount(){
        return amount;
    }

    public Double getPercentage(){
        return percentage;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetPromoCodeDto that )) return false;
        return getId().equals(that.getId()) && getCode().equals(that.getCode()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getPercentage(), that.getPercentage());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), getCode(), getAmount(), getPercentage());
    }

    @Override
    public String toString(){
        return "GetPromoCodeDto{" + "id=" + id + ", code='" + code + '\'' + ", amount=" + amount + ", percentage=" + percentage + '}';
    }
}
