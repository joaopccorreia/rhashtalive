package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.ProductDao;
import com.livestream.rhastalive.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    /**
     * Sets the Product Data Access Point
     * @param productDao
     */
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public Product get(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> listOfActiveProducts() {
        return productDao.findAllActive();
    }

    @Override
    public List<Product> listMerchandising(Integer id) {
        return productDao.findMerchandising();
    }

    @Override
    public Integer add(Product product) {
        return null;
    }

    @Override
    public Boolean remove(Product product) {
        return null;
    }

    @Override
    public int edit(Product product) {
        return 0;
    }
}
