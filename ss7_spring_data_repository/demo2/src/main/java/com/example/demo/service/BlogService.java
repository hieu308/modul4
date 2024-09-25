package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogByTitleContaining(String searchName, Pageable pageable) {
        System.out.println("2");
        if (searchName == null || searchName.isEmpty()) {
            searchName = "";
        }
        String s = "%" + searchName + "%";
        return blogRepository.findBlogByTitleContaining(s, pageable);
    }
}
