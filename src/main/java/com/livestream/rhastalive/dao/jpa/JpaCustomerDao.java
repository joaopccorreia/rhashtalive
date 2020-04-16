package com.livestream.rhastalive.dao.jpa;

import com.livestream.rhastalive.dao.CustomerDao;
import com.livestream.rhastalive.model.users.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCustomerDao extends JpaGenericDao<Customer> implements CustomerDao {

    public JpaCustomerDao() {
        super(Customer.class);
    }

}
