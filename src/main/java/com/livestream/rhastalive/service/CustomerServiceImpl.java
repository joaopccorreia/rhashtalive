package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.jpa.JpaCustomerDao;
import com.livestream.rhastalive.model.Product;
import com.livestream.rhastalive.model.users.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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

    @Override
    @Transactional(readOnly = true)
    public List<Product> listOfBoughtProducts(Integer id) {
        return jpaCustomerDao.findProductBought(id);
    }

    @Transactional
    public void buyProduct(Customer customer) {
        jpaCustomerDao.saveOrUpdate(customer);
    }
}
