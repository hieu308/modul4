package com.example.demo.service;

import com.example.demo.model.Products;
import com.example.demo.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductsService implements IProductsService {
    @Autowired
   private IProductsRepository productsRepository;

    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public void save(Products products) {
        productsRepository.save(products);
    }

    @Override
    public Products findById(int id) {
        return productsRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        productsRepository.delete(id);
    }

    @Override
    public void update(int id, Products products) {
        productsRepository.update(id, products);
    }
}
