package com.pitrzuu.api.order.detail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>{}
