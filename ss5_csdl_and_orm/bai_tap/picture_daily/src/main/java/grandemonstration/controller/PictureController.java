package grandemonstration.controller;


import grandemonstration.model.Picture;
import grandemonstration.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;
import java.util.List;

@Controller
@RequestMapping("/picture")

public class PictureController {

    @Qualifier("pictureRepository")
    @Autowired
    private IPictureRepository iPictureRepository;

    @GetMapping("")
    public ModelAndView getComment() {
        Picture picture = new Picture();
        List<Picture> pictureList = iPictureRepository.getList();
        ModelAndView modelAndView = new ModelAndView("home", "picture", picture);
        modelAndView.addObject("list",pictureList);
        return modelAndView;

    }

    @PostMapping("/create")
    public ModelAndView insertComment(@ModelAttribute("picture") Picture picture) {
        picture.setNumberLike(0);
        iPictureRepository.insert(picture);
        List<Picture> pictureList = iPictureRepository.getList();
        ModelAndView modelAndView = new ModelAndView("home", "list", pictureList);
        return modelAndView;


    }

    @GetMapping("/like/{id}")
    public String getLike(@PathVariable("id")Integer id) {
        Picture picture = iPictureRepository.getByid(id);
        picture.setNumberLike(picture.getNumberLike()+1);
        iPictureRepository.update(picture);
        return "redirect:/picture";

    }



}
