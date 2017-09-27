package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StorageController {

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }
}
