package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Products, Integer> products = new HashMap<Products, Integer>();

    public Cart() {
    }

    public Map<Products, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Products, Integer> products) {
        this.products = products;
    }

    private boolean checkItemCart(Products p) {
        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(p.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Products, Integer> selectItemInCart(Products p) {
        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(p.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Products p) {
        if (!checkItemCart(p)) {
            products.put(p, 1);
        } else {
            Map.Entry<Products, Integer> entry = selectItemInCart(p);
            Integer newQuantity = entry.getValue() + 1;
            products.replace(entry.getKey(), newQuantity);
        }
    }

    public void reduceQuantity(Products p) {
        Map.Entry<Products, Integer> entry = selectItemInCart(p);
        Integer quantity = entry.getValue() ;
        if (quantity > 1) {
            quantity = quantity - 1;
            products.replace(entry.getKey(), quantity);
        }else {
            products.remove(p);
        }
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Float countTotalPayment() {
        float totalPayment = 0;
        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
            totalPayment += (float) (entry.getKey().getPrice() * (float) entry.getValue());
        }
        return totalPayment;
    }

    public void removeProduct(Products product) {
        if (products.containsKey(product)) {
            products.remove(product);
        }

    }
    public void clearCart() {
        products.clear();
    }

}
