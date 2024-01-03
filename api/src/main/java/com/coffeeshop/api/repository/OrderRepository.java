package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query(value = """
            SELECT * FROM order_jn
            """, nativeQuery = true)
    List<OrderEntity> getAllOrders();



}
