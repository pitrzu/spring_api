package com.pitrzuu.api.order.detail.dto;

import com.pitrzuu.api.item.pricing.ESize;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.io.Serializable;
import java.util.Objects;

public class CreateDetailDto implements Serializable{
    private Integer itemId;

    @Min(1)
    private Integer quantity;

    @Min(0)
    @Max(2)
    private ESize size;

    public Integer getItemId(){
        return itemId;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public ESize getSize(){
        return size;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof CreateDetailDto detailDto )) return false;
        return getItemId().equals(detailDto.getItemId()) && getQuantity().equals(detailDto.getQuantity()) && getSize() == detailDto.getSize();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getItemId(), getQuantity(), getSize());
    }

    @Override
    public String toString(){
        return "DetailDto{" + "itemId=" + itemId + ", quantity=" + quantity + ", size=" + size + '}';
    }
}
