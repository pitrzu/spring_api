package com.pitrzuu.api.detail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>{}
