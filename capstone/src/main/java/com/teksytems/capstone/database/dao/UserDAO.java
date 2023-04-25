package com.teksytems.capstone.database.dao;

import com.teksytems.capstone.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {


    @Query("from User u")
    List<User> getAllUsers();

    List<User> findByFirstNameContainingAndLastNameContainingIgnoreCase(String firstName, String lastName);

    List<User> findByFirstNameContainingIgnoreCase(String firstName);

    List<User> findByLastNameContainingIgnoreCase(String lastName);

    User findById(Integer id);

    User findByEmail(String email);

    boolean existsByEmail(String email);
    
    // @Query(value="select distinct(job) from user;", nativeQuery = true)
    // List<String> getAllJobs();

}
