package com.pitrzuu.api.detail.dto;

import com.pitrzuu.api.pricing.GetPriceDto;

import java.util.Objects;

public class GetDetailDto{
    private Long id;
    private String name;
    private String description;
    private String comment;
    private String imgPath;
    private Integer category_id;
    private String category_name;
    private GetPriceDto price;

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getComment(){
        return comment;
    }
    public GetPriceDto getPrice(){
        return price;
    }
    public String getImgPath(){
        return imgPath;
    }
    public Integer getCategory_id(){
        return category_id;
    }
    public String getCategory_name(){
        return category_name;
    }

    public GetDetailDto setId( Long id ){
        this.id = id;
        return this;
    }
    public GetDetailDto setName( String name ){
        this.name = name;
        return this;
    }
    public GetDetailDto setDescription( String description ){
        this.description = description;
        return this;
    }
    public GetDetailDto setComment( String comment ){
        this.comment = comment;
        return this;
    }
    public GetDetailDto setImgPath( String imgPath ){
        this.imgPath = imgPath;
        return this;
    }
    public GetDetailDto setCategory_id( Integer category_id ){
        this.category_id = category_id;
        return this;
    }
    public GetDetailDto setCategory_name( String category_name ){
        this.category_name = category_name;
        return this;
    }
    public GetDetailDto setPrice( GetPriceDto price ){
        this.price = price;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetDetailDto that )) return false;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getDescription().equals(that.getDescription()) && getComment().equals(that.getComment()) && getImgPath().equals(that.getImgPath()) && getCategory_id().equals(that.getCategory_id()) && getCategory_name().equals(that.getCategory_name()) && getPrice().equals(that.getPrice());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getName(), getDescription(), getComment(), getImgPath(), getCategory_id(), getCategory_name(), getPrice());
    }
}
