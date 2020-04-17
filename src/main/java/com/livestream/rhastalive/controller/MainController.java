package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.CustomerDto;
import com.livestream.rhastalive.DTO.UserDto;
import com.livestream.rhastalive.DTO.converters.CustomerDtoToCustomer;
import com.livestream.rhastalive.DTO.converters.UserDtoToUser;
import com.livestream.rhastalive.model.users.Customer;
import com.livestream.rhastalive.model.users.User;
import com.livestream.rhastalive.service.CustomerService;
import com.livestream.rhastalive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/", ""})
public class MainController {

    private CustomerDtoToCustomer customerDtoToCustomer;
    private UserDtoToUser userDtoToUser;
    private UserService userService;
    private CustomerService customerService;

    @Autowired
    public void setCustomerDtoToCustomer(CustomerDtoToCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView showHomePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/signup")
    public ModelAndView signup(Model model) {

        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("user", new UserDto());

        return new ModelAndView("signup");
    }

    @PostMapping("/signup")
    public String editCustomer(@ModelAttribute("customer") CustomerDto customerDto, @ModelAttribute("user") UserDto userDto) {

        Customer customer = customerDtoToCustomer.convert(customerDto);
        User user = userDtoToUser.convert(userDto);

        customerService.save(customer);
        userService.saveOrUpdate(user);

        return "redirect:/shopPage";
    }

    @PostMapping("/login")
    public String loginArtist(){
        return "redirect:/customer";
    }
}
