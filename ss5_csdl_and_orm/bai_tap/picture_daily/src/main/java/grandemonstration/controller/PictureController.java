package grandemonstration.controller;


import grandemonstration.model.Picture;
import grandemonstration.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
        ModelAndView modelAndView = new ModelAndView("home", "picture", picture);
        return modelAndView;

    }

    @PostMapping("/create")
    public String insertComment(@ModelAttribute("picture") Picture picture) {
        iPictureRepository.insert(picture);

        return "redirect:/picture";
    }

//    @PostMapping("/like")
//    public ModelAndView getLike(HttpSession session ){
//
//
//    }


}
