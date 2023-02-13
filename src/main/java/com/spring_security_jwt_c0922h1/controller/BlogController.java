package com.spring_security_jwt_c0922h1.controller;


import com.spring_security_jwt_c0922h1.model.Blog;
import com.spring_security_jwt_c0922h1.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping
    public List<Blog> getAll() {
        return blogService.getAll();
    }

    @PostMapping
    public Blog create(@RequestBody Blog blog) {
        return blogService.save(blog);
    }

    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("/Users/johntoan98gmail.com/Desktop/Module 4/FE_C0922h1/img/" + nameImg));
            return "/img/" + nameImg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public Blog showEdit(@PathVariable int id) {
        return blogService.findById(id);
    }

    @PutMapping("/{id}")
    public Blog edit(@RequestBody Blog blog) {
        return blogService.save(blog);
    }

    @DeleteMapping("/{id}")
    public Blog delete(@PathVariable int id) {
        return blogService.delete(id);
    }

}
