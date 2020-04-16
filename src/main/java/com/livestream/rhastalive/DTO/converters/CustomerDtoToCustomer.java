package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.CustomerDto;
import com.livestream.rhastalive.model.users.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoToCustomer extends AbstractConverters<CustomerDto, Customer> {

    @Override
    public Customer convert(CustomerDto customerDto) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customerDto, Customer.class);

    }
}
