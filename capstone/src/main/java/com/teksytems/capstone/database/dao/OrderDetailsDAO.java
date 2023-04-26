package com.teksytems.capstone.database.dao;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.teksytems.capstone.database.entity.OrderDetails;
import com.teksytems.capstone.database.entity.Orders;



import java.util.*;

public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Long>{

    OrderDetails findById(Integer id);

    @Query(value = "SELECT * FROM order_details od WHERE od.order_id = :orderId AND od.inventory_id = :inventoryId ;", nativeQuery = true)
    OrderDetails findByOrderIdAndInventoryId(Integer orderId, Integer inventoryId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM order_details WHERE inventory_id = :inventoryId ;", nativeQuery = true)
    void deleteFromCart(Integer inventoryId);

    
}
