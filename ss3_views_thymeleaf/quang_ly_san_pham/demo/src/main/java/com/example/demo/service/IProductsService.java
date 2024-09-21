package com.example.demo.service;

import com.example.demo.model.Products;

import java.util.List;

public interface IProductsService {
    List<Products> findAll();
    void save(Products products);
    Products findById(int id);
    void delete(int id);
    void update(int id,Products products);
}
