package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.converters.ShowToShowsDto;
import com.livestream.rhastalive.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/details")
public class DetailsController {

    private ShowService showService;
    private ShowToShowsDto showToShowsDto;

    @Autowired
    public void setShowToShowsDto(ShowToShowsDto showToShowsDto) {
        this.showToShowsDto = showToShowsDto;
    }

    @Autowired
    public void setShowService(ShowService showService) {
        this.showService = showService;
    }


    @GetMapping("/{id}")
    public String listShow(@PathVariable Integer id, Model model){

        model.addAttribute("shows", showToShowsDto.convert(showService.findById(id)));
        return "concertDetails";
    }
}
