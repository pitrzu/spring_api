package com.pitrzuu.api.pricing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPricedItemRepository extends JpaRepository<PricedItem, PriceID>{
    @Query("select p from PricedItem p where p.item.id = :id")
    List<PricedItem> findByItem_Id( @Param("id") Long id );

}
