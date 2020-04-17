package com.livestream.rhastalive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/", ""})
public class MainController {

    @GetMapping
    public ModelAndView showHomePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/login")
    public String loginArtist(){
        return "redirect:/concert/artist/1/add";
    }
}
