package com.pitrzuu.api.detail;

import com.pitrzuu.api.item.Item;
import com.pitrzuu.api.item.addon.Addon;
import com.pitrzuu.api.order.Order;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.NumberFormat;

import java.util.Objects;
import java.util.Set;


@Entity
@IdClass(DetailId.class)
@Table(name = "details")
public class Detail {
    public Detail() { }
    public Detail(Order order, Item item, String comment, Double price) {
        this.order = order;
        this.item = item;
        this.comment = comment;
        this.price = price;
    }
    public Detail(Order order, Item item, Double price, Set<Addon> addons) {
        this.order = order;
        this.item = item;
        this.price = price;
        this.addons = addons;
    }
    public Detail(Order order, Item item, String comment, Double price, Set<Addon> addons) {
        this.order = order;
        this.item = item;
        this.comment = comment;
        this.price = price;
        this.addons = addons;
    }

    @Id
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "order_id", nullable = false, referencedColumnName = "order_id")
    private Order order;

    @Id
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "item_id", nullable = false, referencedColumnName = "item_id")
    private Item item;

    @Column(name = "detail_comment", length = 128)
    private String comment;

    @Column(name = "detail_price")
    @NumberFormat(pattern = "000000.00", style = NumberFormat.Style.NUMBER)
    @JdbcTypeCode(SqlTypes.DECIMAL)
    private Double price;

    @OneToMany(mappedBy = "detail", orphanRemoval = true)
    private Set<Addon> addons = new java.util.LinkedHashSet<>();

    public Order getOrder() {
        return order;
    }
    public Item getItem() {
        return item;
    }
    public String getComment() {
        return comment;
    }
    public Double getPrice() {
        return price;
    }
    public Set<Addon> getAddons() {
        return addons;
    }

    public Detail setOrder(Order order) {
        this.order = order;
        return this;
    }
    public Detail setItem(Item item) {
        this.item = item;
        return this;
    }
    public Detail setComment(String comment) {
        this.comment = comment;
        return this;
    }
    public Detail setPrice(Double price) {
        this.price = price;
        return this;
    }
    public Detail setAddons(Set<Addon> addons) {
        this.addons = addons;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detail detail)) return false;
        return getOrder().equals(detail.getOrder()) && getItem().equals(detail.getItem()) && Objects.equals(getComment(), detail.getComment()) && getPrice().equals(detail.getPrice()) && Objects.equals(getAddons(), detail.getAddons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getItem(), getComment(), getPrice(), getAddons());
    }

    @Override
    public String toString() {
        return "Detail{" +
                "order=" + order +
                ", item=" + item +
                ", comment='" + comment + '\'' +
                ", price=" + price +
                ", addons=" + addons +
                '}';
    }
}
