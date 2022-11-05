package com.pitrzuu.api.item;

import com.pitrzuu.api.item.category.Category;
import com.pitrzuu.api.item.pricing.PricedItem;
import com.pitrzuu.api.order.promocode.PromoCode;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item{
    public Item(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String name;

    @Column(name = "item_description", length = 128)
    private String description;

    @Column(name = "item_img-path", length = 32, nullable = false)
    private String imgPath;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "item")
    private Set<PricedItem> pricedItems = new java.util.LinkedHashSet<>();

    @ManyToMany(mappedBy = "applicableTo")
    private Set<PromoCode> promoCodes = new java.util.LinkedHashSet<>();

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getImgPath(){
        return imgPath;
    }
    public Category getCategory(){
        return category;
    }
    public Set<PricedItem> getPrices(){
        return pricedItems;
    }

    public Item setName( String name ){
        this.name = name;
        return this;
    }
    public Item setDescription( String description ){
        this.description = description;
        return this;
    }
    public Item setImgPath( String imgPath ){
        this.imgPath = imgPath;
        return this;
    }
    public Item setCategory( Category category ){
        this.category = category;
        return this;
    }
    public Item setPrices( Set<PricedItem> pricedItems ){
        this.pricedItems = pricedItems;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof Item item )) return false;
        return getId().equals(item.getId()) && getName().equals(item.getName()) && Objects.equals(getDescription(), item.getDescription()) && getImgPath().equals(item.getImgPath()) && getCategory().equals(item.getCategory()) && Objects.equals(getPrices(), item.getPrices());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(), getName(), getDescription(), getImgPath(), getCategory(), getPrices());
    }
}
