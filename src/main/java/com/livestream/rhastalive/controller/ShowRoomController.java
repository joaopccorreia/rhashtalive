package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/showPage")
public class ShowRoomController {

    @Autowired
    public void setShowService(ShowService showService) {
        this.showService = showService;
    }

    private ShowService showService;

    @GetMapping("/ShowPage/{id}")
    public String watchShow(@PathVariable Integer id, Model model) {

        model.addAttribute("show", showService.findById(id));

        return "showPage";
    }
}
