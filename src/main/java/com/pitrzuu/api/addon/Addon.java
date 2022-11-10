package com.pitrzuu.api.addon;

import com.pitrzuu.api.category.Category;
import com.pitrzuu.api.detail.OrderDetail;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.NumberFormat;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addons")
public class Addon{
    public Addon(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addon_id", nullable = false)
    private Integer id;

    @Column(name = "addon_name", nullable = false)
    private String name;

    @Column(name = "addon_price", nullable = false)
    @NumberFormat(pattern = "000000.00", style = NumberFormat.Style.CURRENCY)
    @JdbcTypeCode(SqlTypes.DECIMAL)
    private Double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "addons")
    private Set<OrderDetail> orderedIn = new java.util.LinkedHashSet<>();

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
    public Category getCategory(){
        return category;
    }
    public Set<OrderDetail> getOrderedIn(){return orderedIn;}


    public Addon setName( String name ){
        this.name = name;
        return this;
    }
    public Addon setPrice( Double price ){
        this.price = price;
        return this;
    }
    public Addon setCategory( Category category ){
        this.category = category;
        return this;
    }
    public Addon setOrderedIn( Set<OrderDetail> orderedIn ){
        this.orderedIn = orderedIn;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof Addon addon )) return false;
        return getId().equals(addon.getId()) && getName().equals(addon.getName()) && getPrice().equals(addon.getPrice()) && getCategory().equals(addon.getCategory());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getName(), getPrice(), getCategory());
    }
}
