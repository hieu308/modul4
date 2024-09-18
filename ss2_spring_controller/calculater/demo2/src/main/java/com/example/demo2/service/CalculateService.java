package com.example.demo2.service;

import com.example.demo2.repository.ICalculateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {
    @Autowired
    ICalculateRepository calculateRepository;

    @Override
    public double calculate(double a, double b, String operation) {
        System.out.println(a+b+operation);
        return calculateRepository.calculate(a, b, operation);
    }
}
