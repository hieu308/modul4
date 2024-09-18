package com.example.demo.service;

import com.example.demo.repository.IDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionary dictionary;

    @Override
    public Map<String, String> getDictionary() {
        return dictionary.getDictionary();
    }
}
