package com.example.controller;

import com.example.model.Smartphone;
import com.example.service.IphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private IphoneService iphoneService;

    @PostMapping()
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(iphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("smartphones", iphoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(iphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/update")
    ResponseEntity<Void> updatePath(@RequestBody Smartphone smartphone) {
        iphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);

    }

//    @GetMapping("/{id}")
//    public ModelAndView show(@PathVariable("id")Long id){
//        Optional<Smartphone> smartphoneOptional = iphoneService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("edit","phone",smartphoneOptional.get());
//        return modelAndView;
//    }

    @GetMapping("/{id}")
    ResponseEntity<Smartphone>phoneById(@PathVariable("id")Long id){
        Optional<Smartphone> smartphoneOptional = iphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneOptional.get(),HttpStatus.OK);

    }

}
