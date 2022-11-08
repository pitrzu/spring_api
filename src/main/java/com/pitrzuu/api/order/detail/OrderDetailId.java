package com.pitrzuu.api.order.detail;

import com.pitrzuu.api.item.pricing.PricedItem;
import com.pitrzuu.api.order.Order;

import java.io.Serializable;
import java.util.Objects;

class OrderDetailId implements Serializable{
    public OrderDetailId(){}

    public OrderDetailId( Order order, PricedItem item ){
        this.order = order;
        this.item = item;
    }

    private Order order;
    private PricedItem item;

    public Order getOrder(){
        return order;
    }

    public PricedItem getItem(){
        return item;
    }

    public OrderDetailId setOrder( Order order ){
        this.order = order;
        return this;
    }

    public OrderDetailId setItem( PricedItem item ){
        this.item = item;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof OrderDetailId that )) return false;
        return getOrder().getId().equals(that.getOrder().getId()) && getItem().equals(that.getItem());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getOrder(), getItem());
    }

    @Override
    public String toString(){
        return "OrderDetailId{" + "order=" + order + ", item=" + item + '}';
    }
}
