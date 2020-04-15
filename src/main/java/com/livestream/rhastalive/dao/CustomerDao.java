package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao extends GenericDao<Customer>{


    public CustomerDao() {
        super(Customer.class);
    }
}
