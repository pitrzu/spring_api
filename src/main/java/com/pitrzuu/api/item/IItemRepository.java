package com.pitrzuu.api.item;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IItemRepository extends JpaRepository<Item, Integer>, JpaSpecificationExecutor<Item>{

    @Override
    void deleteById( @NotNull Integer integer );
}
