package com.pitrzuu.api.user;

import com.pitrzuu.api.location.Location;
import com.pitrzuu.api.order.Order;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    public User() {}
    public User(String hash, String salt, Location defaultLocation) {
        this.hash = hash;
        this.salt = salt;
        this.defaultLocation = defaultLocation;
    }

    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private UUID id;

    @Column(name = "user_hash", length = 512)
    private String hash;

    @Column(name = "user_salt", length = 256)
    private String salt;

    @OneToOne(cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    @JoinColumn(name = "location_id", nullable = false)
    private Location defaultLocation;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Order> orders = new java.util.LinkedHashSet<>();


    public UUID getId() {
        return id;
    }
    public String getSalt() {
        return salt;
    }
    public String getHash() {
        return hash;
    }
    public Location getDefaultLocation() {
        return defaultLocation;
    }
    public Set<Order> getOrders() {
        return orders;
    }

    public User setHash(String hash) {
        this.hash = hash;
        return this;
    }
    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }
    public User setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }
    public User setDefaultLocation(Location defaultLocation) {
        this.defaultLocation = defaultLocation;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId().equals(user.getId()) && getHash().equals(user.getHash()) && getSalt().equals(user.getSalt()) && getDefaultLocation().equals(user.getDefaultLocation()) && Objects.equals(getOrders(), user.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHash(), getSalt(), getDefaultLocation(), getOrders());
    }
}
