package com.pitrzuu.api.order.dto;

import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.order.detail.OrderDetail;
import com.pitrzuu.api.order.status.OrderStatusDto;
import com.pitrzuu.api.person.dto.GetPersonDto;
import com.pitrzuu.api.promocode.PromoCode;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class GetOrderDto{
    public GetOrderDto() {}
    public GetOrderDto( Order order ){
        this.id = order.getId();
        this.customerComment = order.getCustomerComment();
        this.totalPrice = order.getTotalPrice();
        this.creationTime = order.getCreationTime();
        this.awaitedTime = order.getAwaitedTime();
        this.promisedTime = order.getPromisedTime();
        this.promoCode = order.getPromoCode() == null ?
                null : new GetPromoCodeDto(order.getPromoCode());
        this.person = new GetPersonDto(order.getPerson());
        this.status = new OrderStatusDto(order.getLatestStatus());
        this.ordered = order.getOrderDetails()
                .stream()
                .map(GetOrderDetailDto::new)
                .collect(Collectors.toSet());
    }

    private Long id;
    private String customerComment;
    private Double totalPrice;
    private Timestamp creationTime;
    private Timestamp awaitedTime;
    private Timestamp promisedTime;
    private GetPromoCodeDto promoCode;
    private GetPersonDto person;
    private OrderStatusDto status;
    private Set<GetOrderDetailDto> ordered;

    public Long getId(){
        return id;
    }
    public String getCustomerComment(){
        return customerComment;
    }
    public Double getTotalPrice(){
        return totalPrice;
    }
    public Timestamp getCreationTime(){
        return creationTime;
    }
    public Timestamp getAwaitedTime(){
        return awaitedTime;
    }
    public Timestamp getPromisedTime(){
        return promisedTime;
    }
    public GetPromoCodeDto getPromoCode(){
        return promoCode;
    }
    public GetPersonDto getPerson(){
        return person;
    }
    public OrderStatusDto getStatus(){
        return status;
    }
    public Set<GetOrderDetailDto> getOrdered(){
        return ordered;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetOrderDto orderDto )) return false;
        return getId().equals(orderDto.getId()) && Objects.equals(getCustomerComment(), orderDto.getCustomerComment()) && getTotalPrice().equals(orderDto.getTotalPrice()) && getCreationTime().equals(orderDto.getCreationTime()) && Objects.equals(getAwaitedTime(), orderDto.getAwaitedTime()) && Objects.equals(getPromisedTime(), orderDto.getPromisedTime()) && Objects.equals(getPromoCode(), orderDto.getPromoCode()) && getPerson().equals(orderDto.getPerson()) && getStatus().equals(orderDto.getStatus()) && getOrdered().equals(orderDto.getOrdered());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getCustomerComment(), getTotalPrice(), getCreationTime(), getAwaitedTime(), getPromisedTime(), getPromoCode(), getPerson(), getStatus(), getOrdered());
    }
}

class GetPromoCodeDto {
    public GetPromoCodeDto( PromoCode promoCode ){
        this.id = promoCode.getId();
        this.code = promoCode.getName();
        this.amount = promoCode.getDiscountAmount();
        this.percentage = promoCode.getDiscountPercentage();
    }

    private final Long id;
    private final String code;
    private final Double amount;
    private final Double percentage;

    public Long getId(){
        return id;
    }
    public String getCode(){
        return code;
    }
    public Double getAmount(){
        return amount;
    }
    public Double getPercentage(){
        return percentage;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetPromoCodeDto that )) return false;
        return getId().equals(that.getId()) && getCode().equals(that.getCode()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getPercentage(), that.getPercentage());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getCode(), getAmount(), getPercentage());
    }

    @Override
    public String toString(){
        return "GetPromoCodeDto{" + "id=" + id + ", code='" + code + '\'' + ", amount=" + amount + ", percentage=" + percentage + '}';
    }
}

class GetOrderDetailDto{
    public GetOrderDetailDto( OrderDetail orderDetail ){
        this.name = orderDetail.getItem().getItem().getName();
        this.description = orderDetail.getItem().getItem().getDescription();
        this.imgPath = orderDetail.getItem().getItem().getImgPath();
        this.categoryId = orderDetail.getItem().getItem().getCategory().getId();
        this.categoryName = orderDetail.getItem().getItem().getCategory().getName();
        this.size = orderDetail.getItem().getSize().name();
        this.price = orderDetail.getPrice();
        this.quantity = orderDetail.getQuantity();
        this.promoCode = orderDetail.getPromoCode() == null ?
                null : new GetPromoCodeDto(orderDetail.getPromoCode());
    }

    private final String name;
    private final String description;
    private final String imgPath;
    private final Integer categoryId;
    private final String categoryName;
    private final String size;
    private final Double price;
    private final Integer quantity;
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
    public String getSize() { return size; }
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
