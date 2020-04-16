package com.livestream.rhastalive.dao.jpa;

import com.livestream.rhastalive.dao.ProductDao;
import com.livestream.rhastalive.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaProductDao extends JpaGenericDao<Product> implements ProductDao {


    /**
     * Initializes a new JPA DAO instance given a session manager and a model type
     */
    public JpaProductDao() {
        super(Product.class);
    }

    public List<Product> findAllActive() {
            return em.createQuery("from " + modelType.getSimpleName() + " where isActive = 1", modelType).getResultList();
    }

    public List<Product> findMerchandising() {
        return em.createQuery("from " + modelType.getSimpleName() + " where productType = Merchandising", modelType).getResultList();
    }

    public List<Product> findShows() {
        return em.createQuery("from " + modelType.getSimpleName() + " where productType = Show", modelType).getResultList();
    }
}
