package com.pitrzuu.api.item.dto;

import com.pitrzuu.api.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IItemRepository extends JpaRepository<Item, Integer>, JpaSpecificationExecutor<Item>{}
