package com.pitrzuu.api.item.dto;

import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreateItemDto implements Serializable{
    private String name;
    private String description;
    private Integer categoryId;
    private String imgPath;
    private final List<@Valid PriceDto> prices = new ArrayList<>();

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
    public List<PriceDto> getPrices(){
        return prices;
    }
}
