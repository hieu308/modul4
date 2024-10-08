package com.example.demo.controller_api;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.jar.JarOutputStream;

@CrossOrigin("*")
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
                                            @RequestParam(defaultValue = "") String searchName) {
        System.out.println("sn= " + searchName);
        Sort sort = Sort.by(Sort.Direction.DESC, "title");
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Blog> blogPage = blogService.findBlogByTitleContaining(searchName, pageable);
        System.out.println(blogPage);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogPage, HttpStatus.OK);
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
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

    @Autowired
    MessageSource messageSource;

    @GetMapping("/i18n/messages")
    public ResponseEntity<Map<String, String>> getMessages(@RequestParam("lang") String lang) {
        Locale locale = new Locale(lang);

        Map<String, String> messages = new HashMap<>();
        messages.put("title", messageSource.getMessage("title", null, locale));
        System.out.println(messages);
        messages.put("content", messageSource.getMessage("content", null, locale));
        messages.put("author", messageSource.getMessage("author", null, locale));
        messages.put("category", messageSource.getMessage("category", null, locale));
        messages.put("action", messageSource.getMessage("action", null, locale));
        return ResponseEntity.ok(messages);
    }
}
