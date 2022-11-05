package com.pitrzuu.api.order.status;

import com.pitrzuu.api.order.Order;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Objects;


@Entity
@Table(name = "order_statuses")
@IdClass(OrderStatusID.class)
public class OrderStatus{
    public OrderStatus(){}
    public OrderStatus( Order order, EOrderStatus orderStatus ){
        this.order = order;
        this.orderStatus = orderStatus;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Id
    private EOrderStatus orderStatus;

    @Column(name = "status_creation-time")
    @CreationTimestamp
    private Timestamp creationTime;

    public Order getOrder(){
        return order;
    }
    public EOrderStatus getOrderStatus(){
        return orderStatus;
    }
    public Timestamp getCreationTime(){
        return creationTime;
    }

    public OrderStatus setOrder( Order order ){
        this.order = order;
        return this;
    }
    public OrderStatus setOrderStatus( EOrderStatus orderStatus ){
        this.orderStatus = orderStatus;
        return this;
    }
    public OrderStatus setCreationTime( Timestamp creationTime ){
        this.creationTime = creationTime;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof OrderStatus that )) return false;
        return getOrder().equals(that.getOrder()) && getOrderStatus() == that.getOrderStatus();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getOrder(), getOrderStatus());
    }
}
