package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.CustomerDao;
import com.livestream.rhastalive.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer get(Integer id) {
        return customerDao.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerDao.saveOrUpdate(customer);
    }

    @Override
    public void delete(Integer id) {

        customerDao.delete(id);
    }

    @Override
    public List<Customer> list() {
        return customerDao.findAll();
    }
}
