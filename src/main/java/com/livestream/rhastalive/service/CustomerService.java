package com.livestream.rhastalive.service;

import com.livestream.rhastalive.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer get(Integer id);

    Customer save(Customer customer) ;

    void delete(Integer id);

    List<Customer> list();



}
