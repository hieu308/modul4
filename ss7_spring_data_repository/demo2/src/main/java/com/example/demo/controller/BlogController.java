package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryss")
    public List<Category> category() {
        return categoryService.findAll();
    }

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "") String searchName, Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "title");
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Blog> blogPage = blogService.findBlogByTitleContaining(searchName, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchName", searchName);
        return "blog";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        System.out.println(blog);
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        System.out.println(blog);
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", true); // Thêm thuộc tính success
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("blogId") long blogId, RedirectAttributes redirectAttributes) {

        blogService.delete(blogId);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";

    }

    @GetMapping("/view")
    public String view(@RequestParam("id") long blogId, Model model) {
        Blog blog = blogService.findById(blogId);
        model.addAttribute("blog", blog);
        return "view";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long blogId, Model model) {
        Blog blog = blogService.findById(blogId);
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", true);

        return "redirect:/";
    }

}
