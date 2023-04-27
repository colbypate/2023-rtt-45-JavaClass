package com.teksytems.capstone.database.dao;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teksytems.capstone.database.entity.Orders;

import java.util.*;

public interface OrdersDAO extends JpaRepository<Orders, Long> {

    @Query(value = "select * from orders o ", nativeQuery = true)
    List<Orders> getAllOrders();

    @Query(value = "select * from orders o where o.id = :id ", nativeQuery = true)
    List<Orders> findOrderById(Integer id);

    @Query("FROM Orders o WHERE o.status = 'Cart' AND o.userId = :userId ")
    Orders findOrderByStatusAndUserId(Integer userId);

    @Query("FROM Orders o WHERE o.status = 'Cart' AND o.userId = :userId ")
    List<Orders> findListByStatusEqualsCartAndUserId(Integer userId);

    @Query(value = "select i.*, od.quantity from inventory i, order_details od where i.id = od.inventory_id and od.order_id = :orderId ;"
            , nativeQuery = true)
    List<Map<String, Object>> findCartProductsByOrderId(Integer orderId);

    @Query(value = "select i.*, od.quantity, o.status from inventory i, order_details od, orders o where i.id = od.inventory_id and od.order_id = o.id and o.status ='Cart' and o.user_id = :userId ;"
            , nativeQuery = true)
    List<Map<String, Object>> findCartProductsByUserId(Integer userId);

    @Query(value = "select i.*, od.quantity from inventory i, order_details od, orders o where i.id = od.inventory_id and od.order_id = o.id and o.status ='Complete' and o.user_id = :userId ;", nativeQuery = true)
    List<Map<String, Object>> findPastOrdersByUserId(Integer userId);
}
