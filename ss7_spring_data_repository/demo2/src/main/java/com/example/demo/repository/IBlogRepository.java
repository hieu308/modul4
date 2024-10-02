package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT * FROM Blog WHERE title LIKE :title", nativeQuery = true)
    Page<Blog> findBlogByTitleContaining(@Param("title") String title, Pageable pageable);

}
