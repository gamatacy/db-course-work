package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query(value = """
            SELECT * FROM order_jn
            """, nativeQuery = true)
    List<OrderEntity> getAllOrders();

    @Query(value = """
            SELECT create_order(:client_id, :address)
            """, nativeQuery = true)
    Long createOrder(@Param("client_id") Integer clientId, @Param("address") String address);

    @Query(value = """
            INSERT INTO coffee_order_jn (order_id, coffee_id) values (:order_id, :coffee_id)
            """, nativeQuery = true)
    void addCoffeeToOrder(@Param("order_id") Integer orderId, @Param("coffee_id") Integer coffeeId);

    @Query(value = """
            INSERT INTO pie_order_jn (order_id, pie_id) values (:order_id, :pie_id)
            """, nativeQuery = true)
    void addPieToOrder(@Param("order_id") Integer orderId, @Param("pie_id") Integer pieId);


    @Query(value = """
            SELECT calculate_order_total_price(:order_id)
            """, nativeQuery = true)
    Double getOrderPrice(@Param("order_id") Integer orderId);


    @Query(value = """
            SELECT * FROM order_jn where id = :order_id
            """, nativeQuery = true)
    OrderEntity getOrderById(@Param("order_id") Integer orderId);


}
