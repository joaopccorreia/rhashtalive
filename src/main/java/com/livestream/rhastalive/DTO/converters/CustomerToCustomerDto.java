package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.CustomerDto;
import com.livestream.rhastalive.model.users.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDto extends AbstractConverters<Customer, CustomerDto> {

   @Override
    public CustomerDto convert(Customer customer) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customer, CustomerDto.class);

    }
}
