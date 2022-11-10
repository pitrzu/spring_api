package com.pitrzuu.api.detail.dto;

import com.pitrzuu.api.pricing.ESize;

import java.util.Objects;

public class CreateDetailDto{
    private Integer quantity;
    private ESize size;
    private Integer itemId;
    private String comment;
    private String promoCode;

    public Integer getQuantity(){
        return quantity;
    }
    public ESize getSize(){
        return size;
    }
    public Integer getItemId(){
        return itemId;
    }
    public String getComment(){
        return comment;
    }
    public String getPromoCode(){
        return promoCode;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreateDetailDto that )) return false;
        return getQuantity().equals(that.getQuantity()) && getSize() == that.getSize() && getItemId().equals(that.getItemId()) && Objects.equals(getComment(), that.getComment()) && Objects.equals(getPromoCode(), that.getPromoCode());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getQuantity(), getSize(), getItemId(), getComment(), getPromoCode());
    }
}
