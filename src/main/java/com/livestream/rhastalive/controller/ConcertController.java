package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.ShowDto;
import com.livestream.rhastalive.DTO.converters.ArtistToArtistDto;
import com.livestream.rhastalive.DTO.converters.ShowsDtoToShows;
import com.livestream.rhastalive.service.ArtistService;
import com.livestream.rhastalive.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/artist")
public class ConcertController {


    private ShowService showService;
    private ArtistService artistService;
    private ArtistToArtistDto toArtistDto;
    private ShowsDtoToShows toShows;

    @Autowired
    public void setShowService(ShowService showService) {
        this.showService = showService;
    }

    @Autowired
    public void setToArtistDto(ArtistToArtistDto toArtistDto) {
        this.toArtistDto = toArtistDto;
    }

    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Autowired
    public void setToShows(ShowsDtoToShows toShows) {
        this.toShows = toShows;
    }

    @GetMapping("/")
    public String showShopPage(){
        return "shopPage";
    }

    @GetMapping("/details")
    public ModelAndView showDetails() {
        return new ModelAndView("concertDetails");
    }

    @GetMapping("/{id}/add")
    public String addShowPage(@PathVariable Integer id, Model model) {

        model.addAttribute("show", new ShowDto());
        model.addAttribute("artist", toArtistDto.convert(artistService.findById(id)));

        return "addConcert";

    }

    @PostMapping("/{id}/add")
    public String addShow(@ModelAttribute("show") ShowDto showDto) {

        showService.saveOrUpdate(toShows.convert(showDto));
        return "redirect:/shopPage";

    }

}


