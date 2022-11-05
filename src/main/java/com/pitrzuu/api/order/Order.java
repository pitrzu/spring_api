package com.pitrzuu.api.order;

import com.pitrzuu.api.location.Location;
import com.pitrzuu.api.order.detail.OrderDetail;
import com.pitrzuu.api.promocode.PromoCode;
import com.pitrzuu.api.order.status.EOrderStatus;
import com.pitrzuu.api.order.status.OrderStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order{
    public Order(){
        this.orderStatuses.add(new OrderStatus(this, EOrderStatus.ORDERED));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    @Column(name = "order_comment", length = 128)
    private String customerComment;

    @Transient
    private Double totalPrice;

    @Column(name = "order_creation-time", nullable = false)
    @CreationTimestamp
    private Timestamp creationTime;

    @Column(name = "order_awaited-time")
    private Timestamp awaitedTime;

    @Column(name = "order_promised-time")
    private Timestamp promisedTime;

    @ManyToOne
    @JoinColumn(name = "promo_id")
    private PromoCode promoCode;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "order", orphanRemoval = true, cascade = { CascadeType.ALL })
    private Set<OrderStatus> orderStatuses = new java.util.LinkedHashSet<>();

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails = new java.util.LinkedHashSet<>();;

    public Long getId(){
        return id;
    }
    public String getCustomerComment(){
        return customerComment;
    }
    public Double getTotalPrice(){
        return totalPrice;
    }
    public Timestamp getCreationTime(){
        return creationTime;
    }
    public Timestamp getAwaitedTime(){
        return awaitedTime;
    }
    public Timestamp getPromisedTime(){
        return promisedTime;
    }
    public PromoCode getPromoCode(){
        return promoCode;
    }
    public Location getLocation(){
        return location;
    }
    public Set<OrderStatus> getOrderStatuses(){
        return orderStatuses;
    }
    public Set<OrderDetail> getOrderDetails(){
        return orderDetails;
    }

    public Order setCustomerComment( String customerComment ){
        this.customerComment = customerComment;
        return this;
    }
    public Order setCreationTime( Timestamp creationTime ){
        this.creationTime = creationTime;
        return this;
    }
    public Order setAwaitedTime( Timestamp awaitedTime ){
        this.awaitedTime = awaitedTime;
        return this;
    }
    public Order setPromisedTime( Timestamp promisedTime ){
        this.promisedTime = promisedTime;
        return this;
    }
    public Order setPromoCode( PromoCode promoCode ){
        this.promoCode = promoCode;
        return this;
    }
    public Order setLocation( Location location ){
        this.location = location;
        return this;
    }
    public Order setOrderStatuses( Set<OrderStatus> orderStatuses ){
        this.orderStatuses = orderStatuses;
        return this;
    }
    public Order setOrderDetails( Set<OrderDetail> orderDetails ){
        this.orderDetails = orderDetails;
        this.totalPrice = this.orderDetails.stream().map(OrderDetail::getPrice).reduce(Double::sum).get();
        return this;
    }


}
