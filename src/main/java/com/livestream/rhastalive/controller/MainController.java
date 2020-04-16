package com.livestream.rhastalive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public ModelAndView showHomePage() {
<<<<<<< HEAD
        return new ModelAndView("showPage");
=======
        return new ModelAndView("videotest");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("index");
>>>>>>> c4d130ece249f7dd055f17797b1010bd3e98e108
    }

    @GetMapping("/signup")
    public ModelAndView signup() {
        return null;
    }
}
