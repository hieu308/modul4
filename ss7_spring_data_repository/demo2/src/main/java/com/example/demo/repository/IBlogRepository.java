package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select * from blog where title like :searchName",nativeQuery = true)
    List<Blog> searchByName(@Param("searchName") String name);

}
