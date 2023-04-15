package com.teksytems.capstone.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksytems.capstone.database.entity.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    
    List<UserRole> findByUserId(Integer id);
    
}
