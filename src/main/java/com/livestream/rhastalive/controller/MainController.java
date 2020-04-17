package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.UserDto;
import com.livestream.rhastalive.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = {"/", ""})
public class MainController {

    @GetMapping
    public ModelAndView showHomePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login", "user", new UserDto());
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/login")
    public String loginArtist(){
        // redirectAttributes.addFlashAttribute("user", userDto);
        return "redirect:/customer";
    }
}
