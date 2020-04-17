package com.livestream.rhastalive.controller;

import com.livestream.rhastalive.DTO.CustomerDto;
import com.livestream.rhastalive.DTO.UserDto;
import com.livestream.rhastalive.DTO.converters.CustomerDtoToCustomer;
import com.livestream.rhastalive.DTO.converters.CustomerToCustomerDto;
import com.livestream.rhastalive.exception.AssociationExistsException;
import com.livestream.rhastalive.exception.CustomerNotFoundException;
import com.livestream.rhastalive.model.users.Customer;
import com.livestream.rhastalive.service.CustomerService;
import com.livestream.rhastalive.service.SecureUserServiceImpl;
import com.livestream.rhastalive.service.UserService;
import com.livestream.rhastalive.service.UserServiceImpl;
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
    public ModelAndView getDashboard(){

        //int id = userService.findByUserName(userDto.getUserName()).getCustomer().getId();

        CustomerDto customerDto = customerToCustomerDto.convert(customerService.get(1));
        return new ModelAndView("userdashboard", "products", customerDto.getListOfBoughtProducts());
    }


    @GetMapping("/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "signup";
    }

    @GetMapping("/{id}/edit")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerToCustomerDto.convert(customerService.get(id)));
        return "shopPage";
    }

    @PostMapping(path = {"/", ""}, params = "action=save")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:/home";
        }

        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));

        redirectAttributes.addFlashAttribute("lastAction", "Saved" + savedCustomer.getFirstName() + " "
                + savedCustomer.getLastName());
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
