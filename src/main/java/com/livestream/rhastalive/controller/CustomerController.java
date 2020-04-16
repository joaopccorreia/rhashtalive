package com.livestream.rhastalive.controller;


import com.livestream.rhastalive.exception.AssociationExistsException;
import com.livestream.rhastalive.model.users.Customer;
import com.livestream.rhastalive.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private CustomerService customerService;

    private CustomertoCustomerDto customertoCustomerDto;
    private CustomerDtoToCustomer customerDtoToCustomer;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomertoCustomerDto(CustomerToCustomerDto customertoCustomerDto) {
        this.customertoCustomerDto = customertoCustomerDto;
    }

    @Autowired
    public void setCustomerDtoToCustomer(CustomerDtoToCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listCustomers(Model model) {
        model.addAttribute("customers", customertoCustomerDto.convert(customerService.list()));
        return "customer/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "customer/add-update";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userName}/edit")
    public String editCustomer(@PathVariable String userName, Model model) {
        model.addAttribute("customer", customertoCustomerDto.convert(customerService.get(userName)));
        return "customer/add-update";
    }

    @Autowired
    public void setCustomertoCustomerDto(CustomerToCustomerDto customertoCustomerDto) {
        this.customertoCustomerDto = customertoCustomerDto;
    }

    @Autowired
    public void setCustomerDtoToCustomer(CustomerDtoToCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/add-update";
        }

        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));

        redirectAttributes.addFlashAttribute("lastAction", "Saved" + savedCustomer.getFirstName() + " " + savedCustomer.getLastName());
        return "redirect:/customer/" + savedCustomer.getUserName();
    }

    @RequestMapping(method = RequestMethod.GET, path = "{userName}/delete")
    public String deleteCustomer(@PathVariable String userName, RedirectAttributes redirectAttributes) throws AssociationExistsException, CustomerNotFoundException {
        Customer customer = customerService.get(userName);
    }
}
