package com.pitrzuu.api.order.detail.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pitrzuu.api.order.detail.OrderDetail;
import com.pitrzuu.api.promocode.dto.GetPromoCodeDto;

import java.util.Objects;

public class GetOrderDetailDto{
    public GetOrderDetailDto( OrderDetail orderDetail ){
        this.name = orderDetail.getItem().getItem().getName();
        this.description = orderDetail.getItem().getItem().getDescription();
        this.imgPath = orderDetail.getItem().getItem().getImgPath();
        this.categoryId = orderDetail.getItem().getItem().getCategory().getId();
        this.categoryName = orderDetail.getItem().getItem().getCategory().getName();
        this.size = orderDetail.getItem().getSize().name();
        this.price = orderDetail.getPrice();
        this.quantity = orderDetail.getQuantity();
        this.promoCode = orderDetail.getPromoCode() == null ? null : new GetPromoCodeDto(orderDetail.getPromoCode());
    }

    private final String name;

    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private final String description;

    private final String imgPath;

    private final Integer categoryId;

    private final String categoryName;

    private final String size;

    private final Double price;

    private final Integer quantity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GetPromoCodeDto promoCode;

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getImgPath(){
        return imgPath;
    }

    public Integer getCategoryId(){
        return categoryId;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public String getSize(){return size;}

    public Double getPrice(){
        return price;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public GetPromoCodeDto getPromoCode(){
        return promoCode;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetOrderDetailDto that )) return false;
        return getName().equals(that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getImgPath(), that.getImgPath()) && getCategoryId().equals(that.getCategoryId()) && getCategoryName().equals(that.getCategoryName()) && getSize().equals(that.getSize()) && getPrice().equals(that.getPrice()) && getQuantity().equals(that.getQuantity()) && Objects.equals(getPromoCode(), that.getPromoCode());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName(), getDescription(), getImgPath(), getCategoryId(), getCategoryName(), getSize(), getPrice(), getQuantity(), getPromoCode());
    }
}
