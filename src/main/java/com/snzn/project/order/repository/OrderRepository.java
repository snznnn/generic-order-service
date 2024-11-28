package com.snzn.project.order.repository;

import com.snzn.project.order.repository.entity.OrderEntity;
import com.snzn.project.order.repository.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Transactional
    @Modifying
    @Query("update OrderEntity o set o.status = :status where o.orderNo = :orderNo")
    void updateStatusByOrderNo(OrderStatus status, String orderNo);

}
