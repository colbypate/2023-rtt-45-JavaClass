package com.example.lab309demo.database.dao;

import com.example.lab309demo.database.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

//@RepositoryRestResource(path = "learningtutorials") if you want to change the endpoint path
public interface TutorialDAO extends JpaRepository<Tutorial, Long> {
    //   findByPublished is a custom method()
    List<Tutorial> findByPublished(boolean published);
}
