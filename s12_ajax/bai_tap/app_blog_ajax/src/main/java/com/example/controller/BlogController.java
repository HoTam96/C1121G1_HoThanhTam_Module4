package com.example.controller;

import com.example.model.BlogPicture;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import com.example.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IFeedBackService iFeedBackService;

    //    lấy list blog có phân trang
    @GetMapping("/home")
    public ResponseEntity<Page<BlogPicture>> getBlog(@PageableDefault(value = 2)
                                                             Pageable pageable,
                                                     @RequestParam Optional<String> keyWord) {

        String keyWordValue = keyWord.orElse("");
        Page<BlogPicture> pictureList = iBlogService.findAll(keyWordValue, pageable);
        return new ResponseEntity<>(pictureList, HttpStatus.OK);

    }

    //    load  blog theo category id
    @GetMapping("/load/{id}")
    public ResponseEntity<Page<BlogPicture>> getCategory(@PageableDefault(value = 2)
                                                                 Pageable pageable, @PathVariable("id") Integer id) {

        Page<BlogPicture> pictureList = iBlogService.findByCategoryId(id, pageable);

        return new ResponseEntity<>(pictureList, HttpStatus.OK);

    }

    //    load category list
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categoryList = iCategoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);

    }


    //    tạo mơi và lưu 1 bog
    @PostMapping("/create")
    public ResponseEntity<Void> saveCustomer(@RequestBody BlogPicture blogPicture) {
        iBlogService.save(blogPicture);
        return new ResponseEntity<>(HttpStatus.OK);

    }


//    @GetMapping("/showEdit/{id}")
//    public ModelAndView showEdit(@PathVariable("id") Integer id) {
////        BlogPicture blogPicture = new BlogPicture();
//        BlogPicture blogPicture = iBlogService.getBlogById(id);
//        List<Category> categoryList = iCategoryService.findAll();
//        ModelAndView modelAndView = new ModelAndView("edit", "blogPicture", blogPicture);
//        modelAndView.addObject("categoryList", categoryList);
//        return modelAndView;
//    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updateBlog(BlogPicture blogPicture) {
        iBlogService.update(blogPicture);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        iBlogService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    view
    @GetMapping("/view/{id}")
    public ResponseEntity<BlogPicture> displayById(@PathVariable Integer id) {
        BlogPicture blogPicture = iBlogService.getBlogById(id);
        if (blogPicture == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(blogPicture, HttpStatus.OK);
    }

//    phần comment


}
