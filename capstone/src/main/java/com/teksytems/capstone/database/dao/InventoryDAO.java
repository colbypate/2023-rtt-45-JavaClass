package com.teksytems.capstone.database.dao;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teksytems.capstone.database.entity.Inventory;

import java.util.*;

public interface InventoryDAO extends JpaRepository<Inventory, Long>{

    Inventory findById(Integer id);

    @Query(value="select * from inventory i", nativeQuery = true)
    List<Inventory>getAllInventories();

    @Query(value="select * from inventory i where i.product_name like %:productName% ", nativeQuery = true)
    List<Inventory> findInventoryByProductName(String productName);

    @Query(value="select * from inventory i where i.product_name like %:productName% ", nativeQuery = true)
    Inventory findInventoryByProductNameExact(String productName);



    
}
