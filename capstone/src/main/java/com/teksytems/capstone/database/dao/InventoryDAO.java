package com.teksytems.capstone.database.dao;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teksytems.capstone.database.entity.Inventory;

import java.util.*;

public interface InventoryDAO extends JpaRepository<Inventory, Long>{

    @Query(value="select * from inventory i", nativeQuery = true)
    List<Inventory>getAllInventories();

    @Query(value="select * from inventory i where i.product_name like %:productName% ;", nativeQuery = true)
    List<Inventory> findInventoryByProductName(String productName);

    @Query(value="select * from inventory i where i.id = %:id% ;", nativeQuery = true)
    Inventory findInventoryById(Integer id);



    
}
