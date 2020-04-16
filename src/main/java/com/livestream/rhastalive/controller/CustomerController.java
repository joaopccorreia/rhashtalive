package com.livestream.rhastalive.controller;


import com.livestream.rhastalive.DTO.CustomerDto;
import com.livestream.rhastalive.DTO.converters.CustomerDtoToCustomer;
import com.livestream.rhastalive.DTO.converters.CustomerToCustomerDto;
import com.livestream.rhastalive.exception.AssociationExistsException;
import com.livestream.rhastalive.exception.CustomerNotFoundException;
import com.livestream.rhastalive.model.users.Customer;
import com.livestream.rhastalive.model.users.User;
import com.livestream.rhastalive.service.CustomerService;
import com.livestream.rhastalive.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("customer")
public class CustomerController {

    private UserServiceImpl userService;

    private CustomerToCustomerDto customerToCustomerDto;
    private CustomerDtoToCustomer customerDtoToCustomer;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
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

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "customer/add-update";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userName}/edit")
    public String editCustomer(@PathVariable String userName, Model model) {
        model.addAttribute("customer", customerToCustomerDto.convert(userService.loadUserByUsername(userName)));
        return "customer/add-update";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/add-update";
        }

        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));

        redirectAttributes.addFlashAttribute("lastAction", "Saved" + savedCustomer.getFirstName() + " "
                + savedCustomer.getLastName());
        return "redirect:/customer/" + savedCustomer.getUserName();
    }

    @RequestMapping(method = RequestMethod.GET, path = "{userName}/delete")
    public String deleteCustomer(@PathVariable String userName, RedirectAttributes redirectAttributes)
            throws AssociationExistsException, CustomerNotFoundException {
        Customer customer = customerService.get(userName);
        customerService.delete(userName);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted" + customer.getFirstName() + " " + customer.getLastName());
        return "redirect:/customer";
    }

     */
}
