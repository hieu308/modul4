package com.example.demo.repository;

import com.example.demo.model.Products;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;
@Transactional
@Repository
public class ProductsRepository implements IProductsRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Products> findAll() {
        TypedQuery<Products> query = entityManager.createQuery("select c from Products c", Products.class);
        return query.getResultList();
    }
    @Override

    public void save(Products products) {
        if (products.getId() != 0) {
            entityManager.merge(products);
        } else {
            entityManager.persist(products);
        }

    }
    @Override
    public Products findById(int id) {
        TypedQuery<Products> query = entityManager.createQuery("select c from Products c where c.id=:id", Products.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void delete(int id) {
        Products products = findById(id);
        if (products != null) {
            entityManager.remove(products);
        }
    }

    @Override
    public void update(int id, Products products) {
        Products existingProduct = findById(id);
        if (existingProduct != null) {
            existingProduct.setName(products.getName());
            existingProduct.setPrice(products.getPrice());
            existingProduct.setDescription(products.getDescription());
            existingProduct.setBrand(products.getBrand());
            entityManager.merge(existingProduct);
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }

}
