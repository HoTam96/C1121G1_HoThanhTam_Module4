package management.controller;

import management.model.Product;
import management.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductRepository iProductRepository;

    @GetMapping("")
    public ModelAndView getListProduct() {
        List<Product> productList = iProductRepository.getAllList();
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
        iProductRepository.insert(product);
        return "redirect:/product";
    }

    @GetMapping("/showEdit/{id}")
    public ModelAndView showProduct(@PathVariable Integer id) {
        Product product = iProductRepository.productById(id);
        ModelAndView modelAndView = new ModelAndView("edit", "product", product);
        return modelAndView;

    }

    @PostMapping("/edit")
    public String update(Product product) {
        iProductRepository.update(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        iProductRepository.delete(id);
        return "redirect:/product";

    }

    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable Integer id) {
        Product product = iProductRepository.productById(id);
        ModelAndView modelAndView = new ModelAndView("view", "product", product);
        return modelAndView;

    }

    @PostMapping("/search")
    public ModelAndView searchProduct(@RequestParam("nameP") String name) {

        List<Product> productList = iProductRepository.search(name);
        ModelAndView modelAndView = new ModelAndView("list", "list", productList);
        return modelAndView;


    }

}