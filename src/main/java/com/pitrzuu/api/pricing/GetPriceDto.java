package com.pitrzuu.api.pricing;

import java.util.Objects;

public class GetPriceDto{
    private String size;
    private Double price;
    private Integer quantity;

    public String getSize(){
        return size;
    }
    public Double getPrice(){
        return price;
    }
    public Integer getQuantity(){
        return quantity;
    }

    public GetPriceDto setSize( String size ){
        this.size = size;
        return this;
    }
    public GetPriceDto setPrice( Double price ){
        this.price = price;
        return this;
    }
    public GetPriceDto setQuantity( Integer quantity ){
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetPriceDto that )) return false;
        return getSize().equals(that.getSize()) && getPrice().equals(that.getPrice()) && getQuantity().equals(that.getQuantity());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getSize(), getPrice(), getQuantity());
    }
}
