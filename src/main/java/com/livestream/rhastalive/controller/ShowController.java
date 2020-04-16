package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/api")
public class ShowController {

    private ShowService showService;

    @Autowired
    public void setShowService(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping(path = {"/show","","/"})
    public ModelAndView showShopPage(){
        return new ModelAndView("shopPage");
    }

    @GetMapping("/concertDetails.html")
    public ModelAndView showDetails() {
        return new ModelAndView("concertDetails");
    }

}


