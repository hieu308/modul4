package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Category category);
    void delete(Category category);
}
