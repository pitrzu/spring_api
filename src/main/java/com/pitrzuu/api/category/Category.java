package com.pitrzuu.api.category;

import com.pitrzuu.api.addon.Addon;
import com.pitrzuu.api.category.possibleSize.PossibleSize;
import com.pitrzuu.api.item.Item;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category{
    public Category(){}
    public Category(String name, String imgPath){
        this.name = name;
        this.imgPath = imgPath;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(name = "category_img-path", nullable = false)
    private String imgPath;

    @OneToMany(mappedBy = "category")
    private Set<Item> items;

    @OneToMany(mappedBy = "category")
    private Set<Addon> possibleAddons;

    @OneToMany(mappedBy = "category")
    private Set<PossibleSize> possibleSizes;

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getImgPath(){
        return imgPath;
    }
    public Set<Item> getItems(){
        return items;
    }
    public Set<Addon> getPossibleAddons(){
        return possibleAddons;
    }
    public Set<PossibleSize> getPossibleSizes(){
        return possibleSizes;
    }

    public Category setName( String name ){
        this.name = name;
        return this;
    }
    public Category setImgPath( String imgPath ){
        this.imgPath = imgPath;
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
    public Category setPossibleSizes( Set<PossibleSize> possibleSizes ){
        this.possibleSizes = possibleSizes;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof Category category )) return false;
        return getId().equals(category.getId()) && getName().equals(category.getName()) && getImgPath().equals(category.getImgPath()) && Objects.equals(getPossibleAddons(), category.getPossibleAddons()) && Objects.equals(getPossibleSizes(), category.getPossibleSizes());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getId(), getName(), getImgPath(), getPossibleAddons(), getPossibleSizes());
    }
}
