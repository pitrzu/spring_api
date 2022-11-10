package com.pitrzuu.api.status;

import com.pitrzuu.api.order.Order;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Objects;


@Entity
@Table(name = "order_statuses")
@IdClass(OrderStatusID.class)
public class OrderStatus{
    public OrderStatus(){}
    public OrderStatus( Order order ){
        this.order = order;
        this.orderStatus = EOrderStatus.ORDERED;
    }
    public OrderStatus( Order order, EOrderStatus orderStatus ){
        this.order = order;
        this.orderStatus = orderStatus;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private Order order;

    @Id
    private EOrderStatus orderStatus;

    @Column(name = "status_creation-time", updatable = false)
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
