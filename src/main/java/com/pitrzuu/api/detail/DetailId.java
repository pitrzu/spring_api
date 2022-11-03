package com.pitrzuu.api.detail;

import com.pitrzuu.api.item.Item;
import com.pitrzuu.api.order.Order;

import java.io.Serializable;
import java.util.Objects;

public class DetailId implements Serializable {
    public DetailId() {}
    public DetailId(Item item, Order order) {
        this.item = item;
        this.order = order;
    }

    private Item item;
    private Order order;

    public Item getItem() {
        return item;
    }
    public Order getOrder() {
        return order;
    }

    public DetailId setItem(Item item) {
        this.item = item;
        return this;
    }
    public DetailId setOrder(Order order) {
        this.order = order;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetailId detailId)) return false;
        return getItem().equals(detailId.getItem()) && getOrder().equals(detailId.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItem(), getOrder());
    }

    @Override
    public String toString() {
        return "DetailId{" +
                "item=" + item +
                ", order=" + order +
                '}';
    }
}
