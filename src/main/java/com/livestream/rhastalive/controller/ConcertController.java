package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.ShowsDto;
import com.livestream.rhastalive.DTO.converters.ArtistToArtistDto;
import com.livestream.rhastalive.DTO.converters.ShowsDtoToShows;
import com.livestream.rhastalive.model.Show;
import com.livestream.rhastalive.service.ArtistService;
import com.livestream.rhastalive.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/concert")
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

    @GetMapping(path = {"/", ""})
    public ModelAndView showShopPage(){
        return new ModelAndView("shopPage");
    }

    @GetMapping("/details")
    public ModelAndView showDetails() {
        return new ModelAndView("concertDetails");
    }

    @GetMapping("/artist/{id}/add")
    public String addShowPage(@PathVariable Integer id, Model model) {

        model.addAttribute("show", new ShowsDto());
        model.addAttribute("artist", toArtistDto.convert(artistService.findById(id)));

        return "addConcert";

    }

    @PostMapping("/artist/{id}/add")
    public String addShow(@ModelAttribute("show") ShowsDto showsDto) {

        showService.saveOrUpdate(toShows.convert(showsDto));

        return "redirect:/";

    }

}

