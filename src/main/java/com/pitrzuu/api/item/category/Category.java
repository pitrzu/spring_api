package com.pitrzuu.api.item.category;

import com.pitrzuu.api.item.Item;
import com.pitrzuu.api.item.addon.Addon;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category{
    public Category(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Item> items;

    @OneToMany(mappedBy = "category")
    private Set<Addon> possibleAddons;

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Set<Item> getItems(){
        return items;
    }
    public Set<Addon> getPossibleAddons(){
        return possibleAddons;
    }

    public Category setName( String name ){
        this.name = name;
        return this;
    }
    public Category setItems( Set<Item> items ){
        this.items = items;
        return this;
    }
    public Category setPossibleAddons( Set<Addon> possibleAddons ){
        this.possibleAddons = possibleAddons;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof Category category )) return false;
        return getId().equals(category.getId()) && getName().equals(category.getName()) && Objects.equals(getItems(), category.getItems()) && Objects.equals(getPossibleAddons(), category.getPossibleAddons());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getName(), getItems(), getPossibleAddons());
    }
}
