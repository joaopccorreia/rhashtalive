package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.ProductDao;
import com.livestream.rhastalive.model.Product;
import com.livestream.rhastalive.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public Product get(Integer id) {
        return productDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> listOfActiveProducts() {
        return productDao.findAllActive();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> listMerchandising(Integer id) {
        return productDao.findMerchandising();
    }

    @Override
    @Transactional
    public Product add(Product product) {
        return productDao.saveOrUpdate(product);
    }

    @Override
    @Transactional
    public Boolean remove(Product product) {

        productDao.delete(product.getId());

        return get(product.getId()) == null;

    }

    @Override
    @Transactional
    public Product edit(Product product) {
        return productDao.saveOrUpdate(product);
    }


    @Override
    @Transactional
    public Product getByShow(Show show){
        return productDao.finByShow(show);
    }

}
