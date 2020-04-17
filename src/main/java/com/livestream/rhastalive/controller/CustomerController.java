package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.CustomerDto;
import com.livestream.rhastalive.DTO.ShowDto;
import com.livestream.rhastalive.DTO.UserDto;
import com.livestream.rhastalive.DTO.converters.CustomerDtoToCustomer;
import com.livestream.rhastalive.DTO.converters.CustomerToCustomerDto;
import com.livestream.rhastalive.DTO.converters.UserDtoToUser;
import com.livestream.rhastalive.DTO.converters.UserToUserDto;
import com.livestream.rhastalive.exception.AssociationExistsException;
import com.livestream.rhastalive.exception.CustomerNotFoundException;
import com.livestream.rhastalive.model.users.Customer;
import com.livestream.rhastalive.model.users.User;
import com.livestream.rhastalive.service.CustomerService;
import com.livestream.rhastalive.service.SecureUserServiceImpl;
import com.livestream.rhastalive.service.UserService;
import com.livestream.rhastalive.service.UserServiceImpl;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;
    private UserService userService;
    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;

    private CustomerToCustomerDto customerToCustomerDto;
    private CustomerDtoToCustomer customerDtoToCustomer;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCustomertoCustomerDto(CustomerToCustomerDto customerToCustomerDto) {
        this.customerToCustomerDto = customerToCustomerDto;
    }

    @Autowired
    public void setCustomerDtoToCustomer(CustomerDtoToCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerToCustomerDto(CustomerToCustomerDto customerToCustomerDto) {
        this.customerToCustomerDto = customerToCustomerDto;
    }

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
        model.addAttribute("customer", customerToCustomerDto.convert(customerService.get(id)));
        return "shopPage";
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
