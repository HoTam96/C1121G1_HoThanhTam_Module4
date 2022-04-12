package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.BorrowBook;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    IBorrowService iBorrowService;

    @GetMapping("")
    public ModelAndView getAll() {
        List<Book> bookList = iBookService.findAll();
        ModelAndView modelAndView = new ModelAndView("book");
        modelAndView.addObject("bookList", bookList);

        return modelAndView;
    }

    @GetMapping("/borrow/{id}")
    public ModelAndView getBorrow(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Book book=iBookService.findById(id);
        if (book.getAmount().equals(0+"")){
            ModelAndView modelAndView = new ModelAndView();
            String message = "sách hiện tại đã được thuê hết";
            redirectAttributes.addFlashAttribute("message",message);
            modelAndView.setViewName("redirect:/book");
            return modelAndView;

        }

        BorrowBook borrowBook = new BorrowBook();
        int code = (int) (100000 * (Math.random()));
        borrowBook.setCode(String.valueOf(code));
        Book books = iBookService.findById(id);
        borrowBook.setBook(books);
        ModelAndView modelAndView = new ModelAndView("Borrow", "borrowBook", borrowBook);
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute BorrowBook borrowBook) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = iBookService.findById(borrowBook.getBook().getId());
        int amount = Integer.parseInt(book.getAmount()) - 1;
        book.setAmount(amount + "");
        if (amount==0){
            book.setStatus("hết sách");
        }
        iBookService.save(book);
        iBorrowService.save(borrowBook);

        modelAndView.setViewName("redirect:/book");
        return modelAndView;
    }


}
