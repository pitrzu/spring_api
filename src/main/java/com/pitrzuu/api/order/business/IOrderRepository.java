package com.pitrzuu.api.order.business;

import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.order.status.EOrderStatus;
import com.pitrzuu.api.order.status.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>{
    @Override
    Optional<Order> findById( Long id );

    @Override
    void deleteById( Long aLong );

    @Query("""
            select distinct o from Order o inner join o.orderStatuses orderStatuses
            where orderStatuses.orderStatus = :orderStatus
            order by o.creationTime""")
    Iterable<Order> findDistinctByOrderStatuses_OrderStatusOrderByCreationTimeAsc( @Param("orderStatus") EOrderStatus orderStatus );

    Iterable<Order> findByLocationUserId( Long id );

    @Query("select distinct o from Order o where o.promoCode.id = :id")
    Iterable<Order> findDistinctByPromoCode_Id( @Param("id") Long id );

    @Query("""
            select count(o) from Order o inner join o.orderStatuses orderStatuses
            where orderStatuses.orderStatus = :orderStatus""")
    long countByOrderStatuses_OrderStatus( @Param("orderStatus") EOrderStatus orderStatus );

    @Transactional
    @Modifying
    @Query("update Order o set o.orderStatuses = :orderStatuses where o.id = :id")
    int updateOrderStatusesById( @NonNull @Param("orderStatuses") OrderStatus orderStatuses, @Param("id") Long id );

    @Override
    <S extends Order> S save( S entity );
}
