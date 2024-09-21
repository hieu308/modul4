package com.example.demo.repository;

import com.example.demo.model.Products;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class ProductsRepository implements IProductsRepository {
    private static final Map<Integer, Products> productsList = new HashMap<>();

    static {
        productsList.put(1, new Products(1, "SuZuKi", 20, "ngon ", "Việt Nam"));
        productsList.put(2, new Products(2, "yamaha", 30, "chất lượng tốt", "Nhật"));
        productsList.put(3, new Products(3, "VINFASRT", 40, "cực xịn ", "Việt Nam"));
    }

    @Override
    public List<Products> findAll() {
        return new ArrayList<>(productsList.values());
    }

    @Override
    public void save(Products products) {
        productsList.put(products.getId(), products);

    }

    @Override
    public Products findById(int id) {
        return productsList.get(id);
    }

    @Override
    public void delete(int id) {
        productsList.remove(id);
    }

    @Override
    public void update(int id, Products products) {
        productsList.put(id, products);

    }
}
