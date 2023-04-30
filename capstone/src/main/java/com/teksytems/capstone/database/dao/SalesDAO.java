package com.teksytems.capstone.database.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teksytems.capstone.database.entity.Sales;

public interface SalesDAO extends JpaRepository<Sales, Long>{
    
    @Query(value = "select * from sales o ", nativeQuery = true)
    List<Sales> getAllSales();

    @Query(value = "select * from sales s where s.id = :id ", nativeQuery = true)
    List<Sales> findSalesById(Integer id);

    @Query("FROM Sales s WHERE s.status = 'Cart' AND s.userId = :userId ")
    Sales findSaleByStatusAndUserId(Integer userId);

    @Query("FROM Sales s WHERE s.status = 'Cart' AND s.userId = :userId ")
    List<Sales> findListOfSalesByStatusEqualsCartAndUserId(Integer userId);

    @Query(value = "select i.*, x.quantity from inventory i, sale_details x where i.id = x.inventory_id and x.sale_id = :saleId ;"
            , nativeQuery = true)
    List<Map<String, Object>> findInvoiceProductsBySaleId(Integer saleId);

    @Query(value = "select i.*, x.quantity, s.status from inventory i, sale_details x, sales s where i.id = x.inventory_id and x.sale_id = s.id and s.status ='Cart' and s.user_id = :userId ;"
            , nativeQuery = true)
    List<Map<String, Object>> findInvoiceProductsByUserId(Integer userId);

    @Query(value = "select i.*, x.quantity from inventory i, sale_details x, sales s where i.id = x.inventory_id and x.sale_id = s.id and s.status ='Complete' and s.user_id = :userId ;", nativeQuery = true)
    List<Map<String, Object>> findPastSalesByUserId(Integer userId);
    
}
