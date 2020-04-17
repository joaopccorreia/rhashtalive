package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.CustomerDto;
import com.livestream.rhastalive.model.users.Customer;
import com.livestream.rhastalive.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoToCustomer extends AbstractConverters<CustomerDto, Customer> {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer convert(CustomerDto customerDto) {

        Customer customer = customerDto.getId() == null ?
                new Customer() :
                customerService.get(customerDto.getId());

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setVatNumber(customerDto.getVatNumber());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());

        return customer;
        /*
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customerDto, Customer.class);
        */

    }
}
