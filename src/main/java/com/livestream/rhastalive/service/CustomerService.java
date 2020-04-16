package com.livestream.rhastalive.service;

import com.livestream.rhastalive.model.Product;
import com.livestream.rhastalive.model.users.Customer;

import java.util.List;

public interface CustomerService {

    Customer get(Integer id);

    Customer save(Customer customer) ;

    void delete(Integer id);

    List<Customer> list();

    List<Product> listOfBoughtProducts(Integer id);



}
