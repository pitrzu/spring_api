package com.pitrzuu.api.order.business;

import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.order.detail.OrderDetail;
import com.pitrzuu.api.order.status.EOrderStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OrderService implements IOrderService{
    public OrderService( IOrderRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    private final IOrderRepository ordersRepository;

    @Override
    public Optional<Order> getOrderById( Long id ){
        return ordersRepository.findById(id);
    }

    @Override
    public Iterable<Order> getOrdersByUserId( Long id ){
        return ordersRepository.findByLocationUserId(id);
    }

    @Override
    public Iterable<Order> getOrdersByPromoCodeId( Long id ){
        return ordersRepository.findDistinctByPromoCode_Id(id);
    }

    @Override
    public Iterable<Order> getOrdersByStatus( EOrderStatus status ){
        return ordersRepository.findDistinctByOrderStatuses_OrderStatusOrderByCreationTimeAsc(status);
    }

    @Override
    public Long countOrdersByStatus( EOrderStatus status ){
        return ordersRepository.countByOrderStatuses_OrderStatus(status);
    }

    @Override
    public boolean updateOrderDetails( Long id, Set<OrderDetail> newDetails ){
        return false;
    }

    @Override
    public boolean updateOrderStatus( Long id, EOrderStatus newStatus ){
        return false;
    }

    @Override
    public Order placeOrder(Order order){
        return ordersRepository.save(order);
    }
}
