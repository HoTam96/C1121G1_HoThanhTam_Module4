package com.example.controller;


import com.example.model.BlogPicture;
import com.example.model.Category;
import com.example.model.FeedBack;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ModelAndView getBlog() {
        FeedBack feedBack = new FeedBack();
        List<BlogPicture>pictureList=iBlogService.findAll();
        List<Category>categoryList=iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("index","pictureList",pictureList);
        modelAndView.addObject("feedBack",feedBack);
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;

    }

    @GetMapping("/load/{id}")
    public ModelAndView getCategory(@PathVariable("id")Integer id){
        List<BlogPicture>pictureList=iBlogService.getListByCateId(id);
        List<Category>categoryList=iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("index","pictureList",pictureList);
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }


}
