package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog student);
    void delete(Long id);
    List<Blog> searchByName( String searchName);
}
