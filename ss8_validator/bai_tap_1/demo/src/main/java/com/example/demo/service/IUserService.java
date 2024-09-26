package com.example.demo.service;

import com.example.demo.model.Users;

import java.util.List;

public interface IUserService {
    List<Users> findAll();
    Users findById(Long id);
    void save(Users student);
    void delete(Long id);
}
