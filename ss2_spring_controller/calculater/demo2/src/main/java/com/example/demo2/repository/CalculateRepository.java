package com.example.demo2.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculateRepository implements ICalculateRepository {
    @Override
    public double calculate(double a, double b, String operation) {

        double result = 0;
        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "x":
                result = a * b;
                break;
            case "/":
                if(b!=0){
                    result = a / b;
                    break;
                }else{
                    throw new IllegalArgumentException("Số chia phải khác 0");

                }



        }
        return result;
    }
}
