package com.example.demo1.service;

import org.springframework.stereotype.Service;

@Service
public class Calculate implements ICalculate {
    @Override
    public double calculate(double number) {
        return number * 23000;
    }
}
