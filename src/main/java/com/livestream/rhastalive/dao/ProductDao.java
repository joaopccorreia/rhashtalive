package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.model.Product;
import com.livestream.rhastalive.model.Show;

import java.util.List;

public interface ProductDao extends Dao<Product> {

    public List<Product> findAllActive();

    public List<Product> findMerchandising();

    public List<Product> findShows();

    Product finByShow(Show show);
}
