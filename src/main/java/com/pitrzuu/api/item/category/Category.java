package com.pitrzuu.api.item.category;

import com.pitrzuu.api.item.Item;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    public Category() {}
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", nullable = false)
    private Integer id;

    @Column(name = "category_name", length = 32)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    private Set<Item> items = new java.util.LinkedHashSet<>();

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Set<Item> getItems() {
        return items;
    }

    public Category setId(Integer id) {
        this.id = id;
        return this;
    }
    public Category setName(String name) {
        this.name = name;
        return this;
    }
    public Category setItems(Set<Item> items) {
        this.items = items;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return getId().equals(category.getId()) && getName().equals(category.getName()) && Objects.equals(getItems(), category.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getItems());
    }
}
