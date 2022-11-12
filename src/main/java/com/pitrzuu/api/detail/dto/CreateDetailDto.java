package com.pitrzuu.api.detail.dto;

import com.pitrzuu.api.pricing.ESize;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

public class CreateDetailDto{
    @Min(1)
    @NotNull
    private Integer quantity;

    @NotNull
    @Pattern(regexp = "(SMALL|MEDIUM|BIG)", flags = {Pattern.Flag.CASE_INSENSITIVE})
    private String size;

    @Min(1)
    @NotNull
    private Integer itemId;

    private String comment;

    @Pattern(regexp = "[A-Z]+")
    private String promoCode;

    public Integer getQuantity(){
        return quantity;
    }
    public ESize getSize(){
        return ESize.valueOf(this.size.toUpperCase());
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
