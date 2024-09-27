package com.example.demo.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {


    private static int accessCount = 0;
    private static int borrowCount = 0;
    private static int returnCount = 0;


    @After("execution(* com.example.demo.controller.BookController.showList(..))")
    public void logAccess() {
        accessCount++;
        System.out.println("----------------------------------------------");
        System.out.println("Số lần truy cập trang danh sách sách: " + accessCount);
    }

    // Đếm số lần mượn sách
    @After("execution(* com.example.demo.controller.BookController.borrow(..))")
    public void logBorrow() {
        borrowCount++;
        System.out.println("----------------------------------------------");
        System.out.println("Số lần mượn sách: " + borrowCount);
    }


    @After("execution(* com.example.demo.controller.BookController.returnBook(..))")
    public void logReturn() {
        returnCount++;
        System.out.println("----------------------------------------------");
        System.out.println("Số lần trả sách: " + returnCount);
    }
}
