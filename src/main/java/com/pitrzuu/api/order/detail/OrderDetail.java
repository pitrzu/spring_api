package com.pitrzuu.api.order.detail;

import com.pitrzuu.api.item.addon.Addon;
import com.pitrzuu.api.item.pricing.PricedItem;
import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.promocode.PromoCode;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.NumberFormat;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_details")
@IdClass(OrderDetailId.class)
public class OrderDetail{
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "item_id"),
            @JoinColumn(name = "item_size")
    })
    private PricedItem item;

    @Column(name = "detail_price", nullable = false)
    @NumberFormat(pattern = "000000.00", style = NumberFormat.Style.CURRENCY)
    @JdbcTypeCode(SqlTypes.DECIMAL)
    private Double price;

    @Column(name = "detail_quantity", nullable = false)
    private Integer quantity;

    @Column(name = "detail_comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "promo_id")
    private PromoCode promoCode;

    @ManyToMany
    @JoinTable(name = "detail_addons", joinColumns = {
                @JoinColumn(name = "order_id"),
                @JoinColumn(name = "item_id"),
                @JoinColumn(name = "item_size")
        }, inverseJoinColumns = @JoinColumn(name = "addon_id")
    )
    private Set<Addon> addons = new java.util.LinkedHashSet<>();

    public Order getOrder(){
        return order;
    }
    public PricedItem getItem(){
        return item;
    }
    public Double getPrice(){
        return price;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public String getComment(){
        return comment;
    }
    public PromoCode getPromoCode(){
        return promoCode;
    }
    public Set<Addon> getAddons(){
        return addons;
    }

    public OrderDetail setOrder( Order order ){
        this.order = order;
        return this;
    }
    public OrderDetail setItem( PricedItem item ){
        this.item = item;
        return this;
    }
    public OrderDetail setPrice( Double price ){
        this.price = price;
        return this;
    }
    public OrderDetail setQuantity( Integer quantity ){
        this.quantity = quantity;
        return this;
    }
    public OrderDetail setComment( String comment ){
        this.comment = comment;
        return this;
    }
    public OrderDetail setPromoCode( PromoCode promoCode ){
        this.promoCode = promoCode;
        return this;
    }
    public OrderDetail setAddons( Set<Addon> addons ){
        this.addons = addons;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof OrderDetail that )) return false;
        return getOrder().equals(that.getOrder()) && getItem().equals(that.getItem()) && getPrice().equals(that.getPrice()) && getQuantity().equals(that.getQuantity()) && getComment().equals(that.getComment()) && getPromoCode().equals(that.getPromoCode()) && Objects.equals(getAddons(), that.getAddons());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getOrder(), getItem(), getPrice(), getQuantity(), getComment(), getPromoCode(), getAddons());
    }

    @Override
    public String toString(){
        return "OrderDetail{, item=" + item + ", price=" + price + ", quantity=" + quantity + ", comment='" + comment + '\'' + ", promoCode=" + promoCode + ", addons=" + addons + '}';
    }
}
