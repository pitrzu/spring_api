package com.pitrzuu.api.item.pricing;

import com.pitrzuu.api.item.Item;
import com.pitrzuu.api.order.detail.OrderDetail;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "prices")
@IdClass(PriceID.class)
public class PricedItem{
    public PricedItem(){}

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Id
    @Column(name = "item_size", nullable = false)
    private ESize size;

    @Column(name = "item_price", nullable = false)
    private Double price;

    @UpdateTimestamp
    @Column(name = "item_price-update-time")
    private Timestamp updateTime;

    @OneToMany(mappedBy = "item")
    private Set<OrderDetail> orderedIn = new java.util.LinkedHashSet<>();

    public Item getItem(){
        return item;
    }
    public ESize getSize(){
        return size;
    }
    public Double getPrice(){
        return price;
    }
    public Timestamp getUpdateTime(){
        return updateTime;
    }
    public Set<OrderDetail> getOrderedIn() { return orderedIn; }

    public PricedItem setItem( Item item ){
        this.item = item;
        return this;
    }
    public PricedItem setSize( ESize size ){
        this.size = size;
        return this;
    }
    public PricedItem setPrice( Double price ){
        this.price = price;
        return this;
    }
    public PricedItem setUpdateTime( Timestamp creationTime ){
        this.updateTime = creationTime;
        return this;
    }
    public PricedItem setOrderedIn( Set<OrderDetail> orderedIn){
        this.orderedIn = orderedIn;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof PricedItem pricedItem1 )) return false;
        return getItem().equals(pricedItem1.getItem()) && getSize() == pricedItem1.getSize() && getPrice().equals(pricedItem1.getPrice());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getItem(), getSize(), getPrice());
    }


    @Override
    public String toString(){
        return "PricedItem{" + "item=" + item + ", size=" + size + ", price=" + price + ", updateTime=" + updateTime + ", orderedIn=" + orderedIn + '}';
    }
}
