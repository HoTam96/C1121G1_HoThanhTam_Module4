package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public ModelAndView getUser() {
        UserDto userDto = new UserDto();
        ModelAndView modelAndView = new ModelAndView("index", "userDto", userDto);
        return modelAndView;
    }
@PostMapping("/save")
    public ModelAndView checkUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        userDto.validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("index", "userDto", userDto);
            return modelAndView;
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.save(user);
        ModelAndView modelAndView = new ModelAndView("result","message","đăng kí thanh công");
        return modelAndView;

    }
}
