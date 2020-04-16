package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.ProductDto;
import com.livestream.rhastalive.DTO.converters.ProductDtoToProduct;
import com.livestream.rhastalive.DTO.converters.ShowToShowsDto;
import com.livestream.rhastalive.service.ProductService;
import com.livestream.rhastalive.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private ProductDtoToProduct productDtoToProduct;
    private ShowToShowsDto showToShowsDto;
    private ShowService showService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/{id/add")
    public String addProduct(@PathVariable Integer id, @ModelAttribute("product") ProductDto productDto){

        productService.add(productDtoToProduct.convert(productDto));

        return "redirect:/";
    }

    @GetMapping("/shop")
    public String listAllShows(Model model){

        model.addAttribute("shows", showToShowsDto.convert(showService.findAllShows()));
        return "/static/templates/shopPage";
    }




}
