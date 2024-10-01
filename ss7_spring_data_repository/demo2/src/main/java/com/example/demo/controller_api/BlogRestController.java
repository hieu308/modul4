package com.example.demo.controller_api;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("v1/api/blogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryss")
    public List<Category> category() {
        return categoryService.findAll();
    }

    @GetMapping("")
    public ResponseEntity<Page<Blog>> index(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "") String searchName, Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "title");
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Blog> blogPage = blogService.findBlogByTitleContaining(searchName, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogPage, HttpStatus.OK);
        }
    }


    @PostMapping(value = "")
    public ResponseEntity<Blog> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long blogId, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(blogId);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(blogId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> view(@PathVariable("id") long blogId) {
        Blog blog = blogService.findById(blogId);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        return new ResponseEntity<>(blog, HttpStatus.OK); // 200;

    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Blog blog) {
        Blog blog1 = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
