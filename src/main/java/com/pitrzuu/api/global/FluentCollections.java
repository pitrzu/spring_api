package com.pitrzuu.api.global;

import java.util.Set;

public class FluentCollections{
    public static <T> Set<T> add( Set<T> collection, T t){
        collection.add(t);
        return collection;
    }
}
