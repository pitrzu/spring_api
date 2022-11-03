package com.pitrzuu.api.order;

import com.pitrzuu.api.detail.Detail;
import com.pitrzuu.api.order.delivery.Delivery;
import com.pitrzuu.api.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.security.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    public Order() {}
    public Order(Timestamp creationTime, Timestamp awaitedTime, User user, Delivery delivery, Set<Detail> details) {
        this.creationTime = creationTime;
        this.awaitedTime = awaitedTime;
        this.user = user;
        this.delivery = delivery;
        this.details = details;
    }
    public Order(Timestamp creationTime, Timestamp promisedTime, Timestamp awaitedTime, User user, Delivery delivery, Set<Detail> details) {
        this.creationTime = creationTime;
        this.promisedTime = promisedTime;
        this.awaitedTime = awaitedTime;
        this.user = user;
        this.delivery = delivery;
        this.details = details;
    }
    public Order(String comment, Timestamp creationTime, Timestamp awaitedTime, User user, Delivery delivery, Set<Detail> details) {
        this.comment = comment;
        this.creationTime = creationTime;
        this.awaitedTime = awaitedTime;
        this.user = user;
        this.delivery = delivery;
        this.details = details;
    }
    public Order(String comment, Timestamp creationTime, Timestamp promisedTime, Timestamp awaitedTime, User user, Delivery delivery, Set<Detail> details) {
        this.comment = comment;
        this.creationTime = creationTime;
        this.promisedTime = promisedTime;
        this.awaitedTime = awaitedTime;
        this.user = user;
        this.delivery = delivery;
        this.details = details;
    }

    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false)
    private UUID id;

    @Column(name = "order_comment", length = 128)
    private String comment;

    @Column(nullable = false)
    private Timestamp creationTime;

    private Timestamp promisedTime;

    @Column(nullable = false)
    private Timestamp awaitedTime;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "user_ID", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Detail> details = new java.util.LinkedHashSet<>();

    public UUID getId() {
        return id;
    }
    public String getComment() {
        return comment;
    }
    public Timestamp getCreationTime() {
        return creationTime;
    }
    public Timestamp getPromisedTime() {
        return promisedTime;
    }
    public Timestamp getAwaitedTime() {
        return awaitedTime;
    }
    public User getUser() {
        return user;
    }
    public Delivery getDelivery() {
        return delivery;
    }
    public Set<Detail> getDetails() {
        return details;
    }

    public Order setComment(String comment) {
        this.comment = comment;
        return this;
    }
    public Order setPromisedTime(Timestamp promisedTime) {
        this.promisedTime = promisedTime;
        return this;
    }
    public Order setAwaitedTime(Timestamp awaitedTime) {
        this.awaitedTime = awaitedTime;
        return this;
    }
    public Order setDetails(Set<Detail> details) {
        this.details = details;
        return this;
    }
    public Order setDelivery(Delivery delivery) {
        this.delivery = delivery;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getId().equals(order.getId()) && Objects.equals(getComment(), order.getComment()) && getCreationTime().equals(order.getCreationTime()) && Objects.equals(getPromisedTime(), order.getPromisedTime()) && getAwaitedTime().equals(order.getAwaitedTime()) && getUser().equals(order.getUser()) && getDelivery().equals(order.getDelivery()) && getDetails().equals(order.getDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getComment(), getCreationTime(), getPromisedTime(), getAwaitedTime(), getUser(), getDelivery(), getDetails());
    }
}
