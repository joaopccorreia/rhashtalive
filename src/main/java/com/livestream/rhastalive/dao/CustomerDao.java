package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.dao.jpa.JpaGenericDao;
import com.livestream.rhastalive.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao extends JpaGenericDao<Customer> {


    public CustomerDao() {
        super(Customer.class);
    }
}
