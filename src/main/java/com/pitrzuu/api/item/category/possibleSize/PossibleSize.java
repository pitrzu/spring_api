package com.pitrzuu.api.item.category.possibleSize;

import com.pitrzuu.api.item.category.Category;
import com.pitrzuu.api.item.pricing.ESize;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "possible_sizes")
@IdClass(PossibleSizeId.class)
public class PossibleSize{
    @Id
    public ESize size;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;

    public ESize getSize(){
        return size;
    }
    public Category getCategory(){
        return category;
    }

    public PossibleSize setSize( ESize size ){
        this.size = size;
        return this;
    }
    public PossibleSize setCategory( Category category ){
        this.category = category;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof PossibleSize that )) return false;
        return getSize() == that.getSize() && getCategory().equals(that.getCategory());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getSize(), getCategory());
    }
    @Override
    public String toString(){
        return "PossibleSize{" + "size=" + size + ", category=" + category + '}';
    }
}
