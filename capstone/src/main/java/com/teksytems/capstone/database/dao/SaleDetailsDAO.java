package com.teksytems.capstone.database.dao;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.teksytems.capstone.database.entity.OrderDetails;
import com.teksytems.capstone.database.entity.SaleDetails;
import com.teksytems.capstone.database.entity.Sales;


import java.util.*;

public interface SaleDetailsDAO extends JpaRepository<SaleDetails, Long> {

    SaleDetails findById(Integer id);

    @Query(value = "SELECT * FROM sale_details s WHERE s.sale_id = :saleId AND s.inventory_id = :inventoryId ;", nativeQuery = true)
    SaleDetails findBySaleIdAndInventoryId(Integer saleId, Integer inventoryId);

    @Query(value = "SELECT * FROM sale_details s WHERE s.sale_id = :saleId ;", nativeQuery = true)
    List<SaleDetails> findBySaleId(Integer saleId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM sale_details WHERE inventory_id = :inventoryId ;", nativeQuery = true)
    void deleteFromInvoice(Integer inventoryId);


}
