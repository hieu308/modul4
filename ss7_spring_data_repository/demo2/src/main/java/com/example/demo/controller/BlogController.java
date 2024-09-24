package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BlogService blogService;
    @GetMapping("")
    public String index(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);

        return "blog";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";

    }
    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
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
    public String update(@ModelAttribute("blog") Blog blog,RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", true);

        return "redirect:/";
    }
    @PostMapping("/search")
    public String searchBlogs(@RequestParam("nameBlog") String name, Model model) {
        System.out.println("alo");
        List<Blog> blogs = blogService.searchByName(name);
        model.addAttribute("blogs", blogs);
        return "blog";
    }
}
