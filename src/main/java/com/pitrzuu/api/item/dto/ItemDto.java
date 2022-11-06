package com.pitrzuu.api.item.dto;

import com.pitrzuu.api.item.pricing.ESize;

import java.io.Serializable;

public class ItemDto implements Serializable{
    private Integer       id;
    private Integer quantity;
    private ESize       size;

    public Integer getId(){
        return id;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public ESize getSize(){
        return size;
    }
}
