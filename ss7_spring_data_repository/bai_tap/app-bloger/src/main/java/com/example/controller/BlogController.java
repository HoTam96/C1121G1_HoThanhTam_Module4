package com.example.controller;


import com.example.model.BlogPicture;
import com.example.model.Category;
import com.example.model.FeedBack;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import javafx.collections.transformation.FilteredList;
import org.hibernate.engine.jdbc.BlobImplementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/home")
    public ModelAndView getBlog(@PageableDefault(value = 1)
                                        Pageable pageable,
                                @RequestParam Optional<String> keyWord) {
//        FeedBack feedBack = new FeedBack();

        String keyWordValue = keyWord.orElse("");
        Page<BlogPicture> pictureList = iBlogService.findAll(keyWordValue, pageable);

        List<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pictureList", pictureList);
//        modelAndView.addObject("feedBack", feedBack);
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("keyWord", keyWordValue);
        return modelAndView;

    }

    @GetMapping("/load/{id}")
    public ModelAndView getCategory(@PageableDefault(value = 1)
                                            Pageable pageable, @PathVariable("id") Integer id) {
        FeedBack feedBack = new FeedBack();

        Page<BlogPicture> pictureList = iBlogService.findByCategoryId(id, pageable);

        List<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pictureList", pictureList);
        modelAndView.addObject("feedBack", feedBack);
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        BlogPicture blogPicture = new BlogPicture();
        List<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("Create", "blogPicture", blogPicture);
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;

    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blogPicture") BlogPicture blogPicture) {
        iBlogService.save(blogPicture);
        return "redirect:/blog/home";
    }

    @GetMapping("/showEdit/{id}")
    public ModelAndView showEdit(@PathVariable("id") Integer id) {
//        BlogPicture blogPicture = new BlogPicture();
        BlogPicture blogPicture = iBlogService.getBlogById(id);
        List<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("edit", "blogPicture", blogPicture);
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute("blogPicture") BlogPicture blogPicture) {
        iBlogService.update(blogPicture);
        return "redirect:/blog/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iBlogService.delete(id);
        return "redirect:/blog/home";
    }

//    phần comment



}
