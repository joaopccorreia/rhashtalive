package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.CustomerDto;
import com.livestream.rhastalive.model.users.Customer;
import com.livestream.rhastalive.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDto extends AbstractConverters<Customer, CustomerDto> {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public CustomerDto convert(Customer customer) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customer, CustomerDto.class);

    }
}
