package com.pitrzuu.api.item.pricing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPricedItemRepository extends JpaRepository<PricedItem, PriceID>{}
