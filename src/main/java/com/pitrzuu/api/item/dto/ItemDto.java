package com.pitrzuu.api.item.dto;

import com.pitrzuu.api.item.Item;

import java.io.Serializable;
import java.util.Set;

public class ItemDto implements Serializable{
    public ItemDto( Item item ){
        this.name = item.getName();
        this.description = item.getDescription();
        this.categoryId = item.getCategory().getId();
        this.imgPath = item.getImgPath();
    }

    private final String name;
    private final String description;
    private final Integer categoryId;
    private final String imgPath;
    private Set<PriceDto> prices = new java.util.LinkedHashSet<>();

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Integer getCategoryId(){
        return categoryId;
    }
    public String getImgPath(){
        return imgPath;
    }
    public Set<PriceDto> getPrices(){
        return prices;
    }

    public ItemDto setPrices( Set<PriceDto> prices ){
        this.prices = prices;
        return this;
    }
}
