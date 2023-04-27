package com.teksytems.capstone.database.dao;

import java.util.List;
import java.util.Map;

import com.teksytems.capstone.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.teksytems.capstone.database.entity.UserRoles;
import org.springframework.transaction.annotation.Transactional;


public interface UserRolesDAO extends JpaRepository<UserRoles, Long> {
    
    List<UserRoles> findByUserId(Integer id);

    @Query(value = "select role_name from user_roles u where u.user_id = :id ; "
            , nativeQuery = true)
    List<UserRoles> findUserRoleByUserId(Integer id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_roles (`user_id`, `role_name`) VALUES (:id, 'USER');"
            , nativeQuery = true)
    void create(Integer id);

}
