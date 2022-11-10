package com.pitrzuu.api.pricing;

import com.pitrzuu.api.item.Item;

import java.io.Serializable;
import java.util.Objects;

public class PriceID implements Serializable{
    public PriceID(){}

    public PriceID( Item item, ESize size ){
        this.item = item;
        this.size = size;
    }

    private Item item;
    private ESize size;

    public Item getItem(){
        return item;
    }

    public ESize getSize(){
        return size;
    }

    public PriceID setItem( Item item ){
        this.item = item;
        return this;
    }

    public PriceID setSize( ESize size ){
        this.size = size;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof PriceID priceID )) return false;
        return getItem().equals(priceID.getItem()) && getSize() == priceID.getSize();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getItem(), getSize());
    }

    @Override
    public String toString(){
        return "PriceID{" + "item=" + item + ", size=" + size + '}';
    }
}
