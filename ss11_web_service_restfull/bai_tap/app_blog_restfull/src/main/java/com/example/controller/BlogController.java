package com.example.controller;


import com.example.model.BlogPicture;
import com.example.model.Category;
import com.example.model.FeedBack;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import com.example.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IFeedBackService iFeedBackService;

    @GetMapping("/home")
    public ResponseEntity<Page<BlogPicture>> getBlog(@PageableDefault(value = 2)
                                                             Pageable pageable,
                                                     @RequestParam Optional<String> keyWord) {

        String keyWordValue = keyWord.orElse("");
        Page<BlogPicture> pictureList = iBlogService.findAll(keyWordValue, pageable);
        List<Category> categoryList = iCategoryService.findAll();

        return new ResponseEntity<>(pictureList,HttpStatus.OK);


    }

    @GetMapping("/load/{id}")
    public ResponseEntity<Page<BlogPicture>>getCategory(@PageableDefault(value = 2)
                                            Pageable pageable, @PathVariable("id") Integer id) {
//        FeedBack feedBack = new FeedBack();

        Page<BlogPicture> pictureList = iBlogService.findByCategoryId(id, pageable);

return new ResponseEntity<>(pictureList,HttpStatus.OK);

    }
//    load category list
    @GetMapping("/category")
    public ResponseEntity<List<Category>>getCategoryList(){
        List<Category> categoryList = iCategoryService.findAll();
        return new ResponseEntity<>(categoryList,HttpStatus.OK);

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

    //    view
    @GetMapping("/view/{id}")
    public ResponseEntity<BlogPicture> displayById(@PathVariable Integer id) {
        BlogPicture blogPicture = iBlogService.getBlogById(id);
        if (blogPicture == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(blogPicture,HttpStatus.OK);
    }

//    phần comment


}
