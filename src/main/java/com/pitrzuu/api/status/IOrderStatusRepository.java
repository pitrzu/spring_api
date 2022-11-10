package com.pitrzuu.api.status;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderStatusRepository extends JpaRepository<OrderStatus, OrderStatusID>{}
