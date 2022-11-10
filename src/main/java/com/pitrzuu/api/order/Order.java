package com.pitrzuu.api.order;

import com.pitrzuu.api.detail.OrderDetail;
import com.pitrzuu.api.person.Person;
import com.pitrzuu.api.promocode.PromoCode;
import com.pitrzuu.api.status.OrderStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "orders")
public class Order{
    public Order(){
        this.orderStatuses.add( new OrderStatus(this) );
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
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

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
    public Person getPerson() {
        return person;
    }
    public Set<OrderStatus> getOrderStatuses(){
        return orderStatuses;
    }
    public Set<OrderDetail> getOrderDetails(){
        return orderDetails;
    }
    public OrderStatus getLatestStatus(){
        return this.getOrderStatuses()
                .stream()
                .reduce(( orderStatusR, orderStatus ) ->
                        orderStatusR.getOrderStatus().ordinal() > orderStatus.getOrderStatus().ordinal() ? orderStatusR : orderStatus
                ).orElse(new OrderStatus(this));
    }

    public Order setCustomerComment( String customerComment ){
        this.customerComment = customerComment;
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
    public Order setPerson( Person person ){
        this.person = person;
        return this;
    }
    public Order setOrderStatuses( Set<OrderStatus> orderStatuses ){
        this.orderStatuses = orderStatuses;
        return this;
    }
    public Order setOrderDetails( Set<OrderDetail> orderDetails ){
        this.totalPrice = orderDetails.stream()
                .map(OrderDetail::getPrice)
                .reduce(Double::sum)
                .orElse(0.0d);
        this.orderDetails = orderDetails
                .stream()
                .map(detail -> detail.setOrder(this))
                .collect(Collectors.toSet());
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof Order order )) return false;
        return getId().equals(order.getId()) && Objects.equals(getCustomerComment(), order.getCustomerComment()) && getTotalPrice().equals(order.getTotalPrice()) && getCreationTime().equals(order.getCreationTime()) && Objects.equals(getAwaitedTime(), order.getAwaitedTime()) && Objects.equals(getPromisedTime(), order.getPromisedTime()) && Objects.equals(getPromoCode(), order.getPromoCode()) && getPerson().equals(order.getPerson());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getCustomerComment(), getTotalPrice(), getCreationTime(), getAwaitedTime(), getPromisedTime(), getPromoCode(), getPerson());
    }

    @Override
    public String toString(){
        return "Order{" + "id=" + id + ", customerComment='" + customerComment + '\'' + ", totalPrice=" + totalPrice + ", creationTime=" + creationTime + ", awaitedTime=" + awaitedTime + ", promisedTime=" + promisedTime + ", promoCode=" + promoCode + ", person=" + person + ", orderStatuses=" + orderStatuses + ", orderDetails=" + orderDetails + '}';
    }
}
