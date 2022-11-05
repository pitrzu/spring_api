package com.pitrzuu.api.order.status;

import com.pitrzuu.api.order.Order;

import java.io.Serializable;
import java.util.Objects;

class OrderStatusID implements Serializable{
    public OrderStatusID(){}
    public OrderStatusID( Order order, EOrderStatus orderStatus ){
        this.order = order;
        this.orderStatus = orderStatus;
    }

    private Order order;
    private EOrderStatus orderStatus;

    public Order getOrder(){
        return order;
    }
    public EOrderStatus getOrderStatus(){
        return orderStatus;
    }

    public OrderStatusID setOrder( Order order ){
        this.order = order;
        return this;
    }
    public OrderStatusID setOrderStatus( EOrderStatus orderStatus ){
        this.orderStatus = orderStatus;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof OrderStatusID that )) return false;
        return getOrder().equals(that.getOrder()) && getOrderStatus() == that.getOrderStatus();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getOrder(), getOrderStatus());
    }
}
