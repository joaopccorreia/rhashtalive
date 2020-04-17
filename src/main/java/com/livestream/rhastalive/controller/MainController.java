package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.CustomerDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/signup")
    public ModelAndView signup(Model model) {

        model.addAttribute("customer", new CustomerDto());
        return new ModelAndView("signup");
    }

    @PostMapping("/login")
    public String loginArtist(){
        return "redirect:/customer";
    }
}
