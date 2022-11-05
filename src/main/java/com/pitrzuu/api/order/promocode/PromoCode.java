package com.pitrzuu.api.order.promocode;

import com.pitrzuu.api.item.Item;
import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.order.detail.OrderDetail;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.NumberFormat;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "promo_codes")
public class PromoCode{
    public PromoCode(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promo_id")
    private Long id;

    @Column(name = "promo_name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "item_discounts",
            joinColumns = {
                @JoinColumn(name = "item_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "code_id")
            }
    )
    private Set<Item> applicableTo = new java.util.LinkedHashSet<>();

    @OneToMany(mappedBy = "promoCode")
    private Set<OrderDetail> applicationItems = new java.util.LinkedHashSet<>();

    @OneToMany(mappedBy = "promoCode")
    private Set<Order> applicationOrders = new java.util.LinkedHashSet<>();

    @Column(name = "promo_amount")
    @NumberFormat(pattern = "000000.00", style = NumberFormat.Style.CURRENCY)
    @JdbcTypeCode(SqlTypes.DECIMAL)
    private Double discountAmount;

    @Column(name = "promo_percentage")
    @NumberFormat(pattern = "000.00", style = NumberFormat.Style.PERCENT)
    private Double discountPercentage;

    @Column(name = "promo_start-time", nullable = false)
    private Timestamp startTime;

    @Column(name = "promo_end-time")
    private Timestamp endTime;

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Set<Item> getApplicableTo(){
        return applicableTo;
    }
    public Set<OrderDetail> getApplicationItems(){
        return applicationItems;
    }
    public Set<Order> getApplicationOrders(){
        return applicationOrders;
    }
    public Double getDiscountAmount(){
        return discountAmount;
    }
    public Double getDiscountPercentage(){
        return discountPercentage;
    }
    public Timestamp getStartTime(){
        return startTime;
    }
    public Timestamp getEndTime(){
        return endTime;
    }

    public PromoCode setId( Long id ){
        this.id = id;
        return this;
    }
    public PromoCode setName( String name ){
        this.name = name;
        return this;
    }
    public PromoCode setApplicableTo( Set<Item> applicableTo ){
        this.applicableTo = applicableTo;
        return this;
    }
    public PromoCode setApplicationItems( Set<OrderDetail> applicationItems ){
        this.applicationItems = applicationItems;
        return this;
    }
    public PromoCode setApplicationOrders( Set<Order> applicationOrders ){
        this.applicationOrders = applicationOrders;
        return this;
    }
    public PromoCode setDiscountAmount( Double discountAmount ){
        this.discountAmount = discountAmount;
        return this;
    }
    public PromoCode setDiscountPercentage( Double discountPercentage ){
        this.discountPercentage = discountPercentage;
        return this;
    }
    public PromoCode setStartTime( Timestamp startTime ){
        this.startTime = startTime;
        return this;
    }
    public PromoCode setEndTime( Timestamp endTime ){
        this.endTime = endTime;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof PromoCode promoCode )) return false;
        return getId().equals(promoCode.getId()) && getName().equals(promoCode.getName()) && Objects.equals(getApplicableTo(), promoCode.getApplicableTo()) && Objects.equals(getDiscountAmount(), promoCode.getDiscountAmount()) && Objects.equals(getDiscountPercentage(), promoCode.getDiscountPercentage()) && getStartTime().equals(promoCode.getStartTime()) && Objects.equals(getEndTime(), promoCode.getEndTime());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), getName(), getApplicableTo(), getDiscountAmount(), getDiscountPercentage(), getStartTime(), getEndTime());
    }
}
