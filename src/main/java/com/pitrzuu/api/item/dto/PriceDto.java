package com.pitrzuu.api.item.dto;

import java.io.Serializable;

public class PriceDto implements Serializable{
    public PriceDto( String size, Double price ){
        this.size = size;
        this.price = price;
    }

    private String size;
    private Double price;

    public String getSize(){
        return size;
    }
    public Double getPrice(){
        return price;
    }
}
