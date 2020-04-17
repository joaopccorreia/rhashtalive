package com.livestream.rhastalive.service;

import com.livestream.rhastalive.model.Product;
import com.livestream.rhastalive.model.Show;

import java.util.List;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface ProductService {

    /**
     * Gets the product with the given id
     *
     * @param id the product id
     * @return the product
     */
    Product get(Integer id);

    /**
     * Gets the list of active produtcts
     *
     * @return the list of active products
     */
    List<Product> listOfActiveProducts();

    /**
     * Gets the list of merchandising of a predetermined artist
     *
     * @param id the artist id
     * @return the list of active products
     */
    List<Product> listMerchandising(Integer id);


    /**
     * Adds a product to the service
     *
     * @param product the Product to add
     * @return product id
     */
    Product add(Product product);

    /**
     * Removes a product from the service
     *
     * @param product the Product to remove
     * @return if successfully removed
     */
    Boolean remove(Product product);

    /**
     * Edits a product from the service
     *
     * @param product the Product to edit
     * @return if successfully edited
     */
    Product edit(Product product);

    public Product getByShow(Show show);

}
