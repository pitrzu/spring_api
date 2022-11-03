package com.pitrzuu.api.item;

import com.pitrzuu.api.detail.Detail;
import com.pitrzuu.api.item.category.Category;
import jakarta.persistence.*;
import org.springframework.format.annotation.NumberFormat;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item {
    public Item() {
    }
    public Item(String name, String description, Double price, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = categories;
    }
    public Item(String name, String description, String imagePath, Double price, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.price = price;
        this.categories = categories;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", nullable = false)
    private Long id;

    @Column(name = "item_name", nullable = false, unique = true, length = 64)
    private String name;

    @Column(name = "item_description", nullable = false, length = 128)
    private String description;

    @Column(name = "item_image-path", unique = true, length = 64)
    private String imagePath;

    @Column(name = "item_price", nullable = false)
    @NumberFormat(pattern = "000000.00", style = NumberFormat.Style.CURRENCY)
    private Double price;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "items_categories",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id", referencedColumnName = "category_id"))
    private Set<Category> categories = new java.util.LinkedHashSet<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Detail> details = new java.util.LinkedHashSet<>();

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getImagePath() {
        return imagePath;
    }
    public Double getPrice() {
        return price;
    }
    public Set<Category> getCategories() {
        return categories;
    }
    public Set<Detail> getDetails() {
        return details;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }
    public Item setDescription(String description) {
        this.description = description;
        return this;
    }
    public Item setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }
    public Item setPrice(Double price) {
        this.price = price;
        return this;
    }
    public Item setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
    public Item setDetails(Set<Detail> details) {
        this.details = details;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return getId().equals(item.getId()) && getName().equals(item.getName()) && getDescription().equals(item.getDescription()) && Objects.equals(getImagePath(), item.getImagePath()) && getPrice().equals(item.getPrice()) && Objects.equals(getCategories(), item.getCategories()) && Objects.equals(getDetails(), item.getDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getImagePath(), getPrice(), getCategories(), getDetails());
    }
}
