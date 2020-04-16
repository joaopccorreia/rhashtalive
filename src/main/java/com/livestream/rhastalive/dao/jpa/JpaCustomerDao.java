package com.livestream.rhastalive.dao.jpa;

import com.livestream.rhastalive.dao.CustomerDao;
import com.livestream.rhastalive.model.Product;
import com.livestream.rhastalive.model.users.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaCustomerDao extends JpaGenericDao<Customer> implements CustomerDao {

    public JpaCustomerDao() {
        super(Customer.class);
    }

    public List<Product> findProductBought(Integer customerId) {
        return em.createQuery("from customer_product where customer_id = " + customerId).getResultList();
    }

}
