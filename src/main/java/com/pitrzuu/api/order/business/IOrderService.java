package com.pitrzuu.api.order.business;

import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.order.detail.OrderDetail;
import com.pitrzuu.api.order.status.EOrderStatus;

import java.util.Optional;
import java.util.Set;

public interface IOrderService{
    Optional<Order> getOrderById( Long id);
    Iterable<Order> getOrdersByUserId(Long id);
    Iterable<Order> getOrdersByPromoCodeId(Long id);
    Iterable<Order> getOrdersByStatus( EOrderStatus status);
    Long countOrdersByStatus(EOrderStatus status);
    boolean updateOrderDetails(Long id, Set<OrderDetail> newDetails);
    boolean updateOrderStatus(Long id, EOrderStatus newStatus);
    Order placeOrder(Order order);
}
