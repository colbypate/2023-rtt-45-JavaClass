package com.teksytems.capstone.database.dao;

import com.teksytems.capstone.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {


    @Query("from User u")

    List<User> getAllUsers();

    User findById(Integer id);










}
