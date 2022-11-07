package com.pitrzuu.api.order.status;

import java.sql.Timestamp;
import java.util.Objects;

public class OrderStatusDto{
    public OrderStatusDto( OrderStatus orderStatus ){
        this.status = orderStatus.getOrderStatus().name();
        this.creationTime = orderStatus.getCreationTime();
    }

    private final String status;
    private final Timestamp creationTime;

    public String getStatus(){
        return status;
    }
    public Timestamp getCreationTime(){
        return creationTime;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof OrderStatusDto that )) return false;
        return getStatus().equals(that.getStatus()) && getCreationTime().equals(that.getCreationTime());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getStatus(), getCreationTime());
    }

    @Override
    public String toString(){
        return "GetOrderStatusDto{" + "status='" + status + '\'' + ", creationTime=" + creationTime + '}';
    }
}
