package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/concert")
public class ConcertController {

    private ShowService showService;

    @Autowired
    public void setShowService(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping(path = {"/", ""})
    public ModelAndView showShopPage(){
        return new ModelAndView("shopPage");
    }

    @GetMapping("/details")
    public ModelAndView showDetails() {
        return new ModelAndView("concertDetails");
    }

    @GetMapping("/add")
    public ModelAndView addConcert() {
        return null;
    }

}


