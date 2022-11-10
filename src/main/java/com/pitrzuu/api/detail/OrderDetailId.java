package com.pitrzuu.api.detail;

import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.pricing.PricedItem;

import java.io.Serializable;
import java.util.Objects;

class OrderDetailId implements Serializable{
    public OrderDetailId(){}

    public OrderDetailId( Order order, PricedItem pricedItem ){
        this.order = order;
        this.pricedItem = pricedItem;
    }

    private Order order;
    private PricedItem pricedItem;

    public Order getOrder(){
        return order;
    }

    public PricedItem getPricedItem(){
        return pricedItem;
    }

    public OrderDetailId setOrder( Order order ){
        this.order = order;
        return this;
    }

    public OrderDetailId setPricedItem( PricedItem item ){
        this.pricedItem = item;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof OrderDetailId that )) return false;
        return getOrder().getId().equals(that.getOrder().getId()) && getPricedItem().equals(that.getPricedItem());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getOrder(), getPricedItem());
    }

    @Override
    public String toString(){
        return "OrderDetailId{" + "order=" + order + ", item=" + pricedItem + '}';
    }
}
