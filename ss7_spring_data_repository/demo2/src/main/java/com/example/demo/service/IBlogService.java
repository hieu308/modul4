package com.example.demo.service;

import com.example.demo.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog student);
    void delete(Long id);
    Page<Blog> findBlogByTitleContaining(String searchName, Pageable pageable);
}
