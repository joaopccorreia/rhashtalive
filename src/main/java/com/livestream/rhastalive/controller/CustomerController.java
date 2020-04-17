package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.CustomerDto;
import com.livestream.rhastalive.DTO.ShowDto;
import com.livestream.rhastalive.DTO.converters.*;
import com.livestream.rhastalive.DTO.UserDto;
import com.livestream.rhastalive.DTO.converters.CustomerDtoToCustomer;
import com.livestream.rhastalive.DTO.converters.CustomerToCustomerDto;
import com.livestream.rhastalive.DTO.converters.UserDtoToUser;
import com.livestream.rhastalive.DTO.converters.UserToUserDto;

import com.livestream.rhastalive.exception.AssociationExistsException;
import com.livestream.rhastalive.exception.CustomerNotFoundException;
import com.livestream.rhastalive.model.Product;
import com.livestream.rhastalive.model.users.Customer;
import com.livestream.rhastalive.service.*;
import lombok.Setter;
import com.livestream.rhastalive.model.users.User;
import com.livestream.rhastalive.service.CustomerService;
import com.livestream.rhastalive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Setter
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;

    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;

    @Autowired
    private ShowService showService;
    @Autowired
    private CustomerToCustomerDto customerToCustomerDto;
    @Autowired
    private CustomerDtoToCustomer customerDtoToCustomer;
    @Autowired
    private ShowToShowsDto showToShowsDto;
    @Autowired
    private ShowsDtoToShows showsDtoToShows;
    @Autowired
    private ProductService productService;

    @GetMapping({"/", ""})
    public String getDashboard(Model model){

        //int id = userService.findByUserName(userDto.getUserName()).getCustomer().getId();

        CustomerDto customerDto = customerToCustomerDto.convert(customerService.get(1));
        model.addAttribute("products", customerDto.getListOfBoughtProducts());
        model.addAttribute("customer", customerDto);
        return "userdashboard";
    }

    @GetMapping("{id}")
    public String userDashboard(@PathVariable("id") Integer id, Model model){

        CustomerDto customerDto = customerToCustomerDto.convert(customerService.get(id));
        model.addAttribute("products", customerDto.getListOfBoughtProducts());
        model.addAttribute("customer", customerDto);
        return "userdashboard";
    }


    @GetMapping("/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("user", new UserDto());
        return "signup";
    }

    @GetMapping("/{id}/edit/")
    public String editCustomer(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customer", customerToCustomerDto.convert(customerService.get(id)));
        return "edituser";
    }

    @GetMapping("/{id}/shop/")
    public String goToShop(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("shows", showToShowsDto.convert(showService.findAllShows()));
        model.addAttribute("customer", customerToCustomerDto.convert(customerService.get(id)));
        return "shopPage";
    }

    @GetMapping("/{cid}/buy/{sid}")
    public String editCustomer(@PathVariable("cid") Integer customer_id, @ModelAttribute("sid") Integer show_id) {

        ShowDto showDto = showToShowsDto.convert(showService.findById(show_id));
        CustomerDto customerDto = customerToCustomerDto.convert(customerService.get(customer_id));

        List<Product> productList = customerDto.getListOfBoughtProducts();
        Product product = productService.getByShow(showsDtoToShows.convert(showDto));
        productList.add(productList.size(), product);

        customerDto.setListOfBoughtProducts(productList);

        productService.edit(product);
        customerService.save(customerDtoToCustomer.convert(customerDto));

        return "redirect:/customer/" + customer_id;
    }

    @PostMapping("/{id}/edit/")
    public String editCustomer(@ModelAttribute("customer") CustomerDto customerDto, @ModelAttribute("user") UserDto userDto) {

        Customer customer = customerDtoToCustomer.convert(customerDto);
        User user = userDtoToUser.convert(userDto);

        customerService.save(customer);
        userService.saveOrUpdate(user);

        return "redirect:/shopPage";
    }

    @GetMapping (path = "{id}/delete")
    public String deleteCustomer(@PathVariable Integer id, RedirectAttributes redirectAttributes)
            throws AssociationExistsException, CustomerNotFoundException {
        Customer customer = customerService.get(id);
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted" + customer.getFirstName() + " " + customer.getLastName());
        return "home";
    }
}