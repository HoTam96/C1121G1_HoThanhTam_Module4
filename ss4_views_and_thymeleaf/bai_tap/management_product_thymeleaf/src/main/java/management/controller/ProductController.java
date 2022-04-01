package management.controller;

import management.model.Product;
import management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public ModelAndView getListProduct() {
        List<Product> productList = iProductService.getAllList();
        ModelAndView modelAndView = new ModelAndView("list", "list", productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView newCreate() {
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView("create", "product", product);
        return modelAndView;
    }

    @PostMapping("/insert")
    public String insertProduct(Product product) {
        iProductService.insert(product);
        return "redirect:/product";
    }

    @GetMapping("/showEdit/{id}")
    public ModelAndView showProduct(@PathVariable Integer id) {
        Product product = iProductService.productById(id);
        ModelAndView modelAndView = new ModelAndView("edit", "product", product);
        return modelAndView;

    }

    @PostMapping("/edit")
    public String update(Product product) {
        iProductService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        iProductService.delete(id);
        return "redirect:/product";

    }

    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable Integer id) {
        Product product = iProductService.productById(id);
        ModelAndView modelAndView = new ModelAndView("view", "product", product);
        return modelAndView;

    }

    @PostMapping("/search")
    public ModelAndView searchProduct(@RequestParam("nameP") String name) {

        List<Product> productList = iProductService.search(name);
        ModelAndView modelAndView = new ModelAndView("list", "list", productList);
        return modelAndView;


    }

}