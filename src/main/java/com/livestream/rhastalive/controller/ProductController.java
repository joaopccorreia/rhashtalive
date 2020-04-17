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
    public void setProductDtoToProduct(ProductDtoToProduct productDtoToProduct) {
        this.productDtoToProduct = productDtoToProduct;
    }

    @Autowired
    public void setShowToShowsDto(ShowToShowsDto showToShowsDto) {
        this.showToShowsDto = showToShowsDto;
    }

    @Autowired
    public void setShowService(ShowService showService) {
        this.showService = showService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/{id/add")
    public String addProduct(@PathVariable Integer id, ProductDto productDto){

        productService.add(productDtoToProduct.convert(productDto));

        return "redirect:/shopPage";
    }

    @GetMapping("/shop")
    public String listAllShows(Model model){

        System.out.println(model.addAttribute("shows", showToShowsDto.convert(showService.findAllShows())));

        return "shopPage";
    }




}
