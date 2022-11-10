package com.pitrzuu.api.status;

import java.sql.Timestamp;
import java.util.Objects;

public class GetOrderStatusDto{
    private String status;
    private Timestamp time;

    public String getStatus(){
        return status;
    }
    public Timestamp getTime(){
        return time;
    }

    public GetOrderStatusDto setStatus( String status ){
        this.status = status;
        return this;
    }
    public GetOrderStatusDto setTime( Timestamp time ){
        this.time = time;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof GetOrderStatusDto that )) return false;
        return getStatus().equals(that.getStatus()) && getTime().equals(that.getTime());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getStatus(), getTime());
    }
}
