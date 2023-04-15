package com.teksytems.capstone.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksytems.capstone.database.entity.Sales;

public interface SalesDAO extends JpaRepository<Sales, Long>{
    
    
}
