package com.pitrzuu.api.order.delivery;

import com.pitrzuu.api.location.Location;
import com.pitrzuu.api.order.Order;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "deliveries")
public class Delivery {
    public Delivery() {}
    public Delivery(Long id, Order order, DeliveryType dt, Location location) {
        this.id = id;
        this.order = order;
        this.dt = dt;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "delivery_id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated
    @Column(name = "delivery_type")
    private DeliveryType dt;

    @OneToOne(cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Order getOrder() {
        return order;
    }
    public Location getLocation() {
        return location;
    }
    public Long getId(){ return id; }
    public DeliveryType getDt(){ return dt; }

    public void setOrder(Order order) {
        this.order = order;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery delivery)) return false;
        return getId().equals(delivery.getId()) && getOrder().equals(delivery.getOrder()) && getDt() == delivery.getDt() && getLocation().equals(delivery.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrder(), getDt(), getLocation());
    }
}
