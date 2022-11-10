package com.pitrzuu.api.category.possibleSize;

import com.pitrzuu.api.category.Category;
import com.pitrzuu.api.pricing.ESize;

import java.io.Serializable;
import java.util.Objects;

class PossibleSizeId implements Serializable{
    public PossibleSizeId(){}

    public PossibleSizeId( ESize size, Category category ){
        this.size = size;
        this.category = category;
    }

    public ESize size;
    public Category category;

    public ESize getSize(){
        return size;
    }

    public Category getCategory(){
        return category;
    }

    public PossibleSizeId setSize( ESize size ){
        this.size = size;
        return this;
    }

    public PossibleSizeId setCategory( Category category ){
        this.category = category;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof PossibleSizeId that )) return false;
        return getSize() == that.getSize() && getCategory().equals(that.getCategory());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getSize(), getCategory());
    }
}
