package com.example.demo.service;

import com.example.demo.model.Products;

import java.util.Optional;

public interface IProductsService {
    Iterable<Products> findAllProducts();
    Optional<Products> findProductsById(Long id);
}
