package com.pitrzuu.api.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>{
    Optional<Order> findOrderById(Long id);

    @Query("DELETE FROM Order o WHERE o.id = :id")
    int removeById(Long id);
}
