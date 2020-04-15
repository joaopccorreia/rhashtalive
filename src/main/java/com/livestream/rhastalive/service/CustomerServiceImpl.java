package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.jpa.JpaCustomerDao;
import com.livestream.rhastalive.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private JpaCustomerDao jpaCustomerDao;

    @Autowired
    public void setJpaCustomerDao(JpaCustomerDao jpaCustomerDao) {
        this.jpaCustomerDao = jpaCustomerDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Customer get(Integer id) {
        return jpaCustomerDao.findById(id);
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return jpaCustomerDao.saveOrUpdate(customer);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        jpaCustomerDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> list() {
        return jpaCustomerDao.findAll();
    }
}
