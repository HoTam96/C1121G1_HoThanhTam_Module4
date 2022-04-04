package grandemonstration.controller;


import grandemonstration.model.Picture;
import grandemonstration.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/picture")

public class PictureController {

    @Qualifier("pictureRepository")
    @Autowired
    private IPictureRepository iPictureRepository;

    @RequestMapping("")
    public String getPicture(){
        return "home";
    }

}
