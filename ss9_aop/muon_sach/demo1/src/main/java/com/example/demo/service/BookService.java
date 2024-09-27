package com.example.demo.service;

import com.example.demo.exception.CodeException;
import com.example.demo.exception.QuantityException;
import com.example.demo.model.Book;
import com.example.demo.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void checkQuantity(Book book) throws QuantityException {
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            save(book);
        } else {
            throw new QuantityException("Không có sách để mượn");
        }
    }

    @Override
    public void checkCode(String code) throws CodeException {
        List<Book> list = bookRepository.findAll();
        for (Book book : list) {
            if (book.getCodeBook().equals(code)) {
                book.setQuantity(book.getQuantity() + 1);
                bookRepository.save(book);
                return;
            }
        }
        throw new CodeException("Mã sách trả không đúng");
    }
}
