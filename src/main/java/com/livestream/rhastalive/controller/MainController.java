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
        return new ModelAndView("home");
    }

}