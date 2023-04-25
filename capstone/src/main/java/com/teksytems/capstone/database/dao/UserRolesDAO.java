package com.teksytems.capstone.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksytems.capstone.database.entity.UserRoles;

public interface UserRolesDAO extends JpaRepository<UserRoles, Long> {
    
    List<UserRoles> findByUserId(Integer id);
    
}
