package com.example.demo.service;


import com.example.demo.exception.CodeException;
import com.example.demo.exception.QuantityException;
import com.example.demo.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Long id);

    void save(Book book);

    void checkQuantity(Book book) throws QuantityException;
    void checkCode(String code) throws CodeException;

    void delete(Book book);
}
