package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class Dictionary implements IDictionary {
    private static final Map<String,String> list = new HashMap<>();
    static{
        list.put("dog","chó");
        list.put("cat","mèo");
        list.put("human","người");

    }

    @Override
    public Map<String, String> getDictionary() {
        return list;
    }
}
