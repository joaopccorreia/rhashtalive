package com.livestream.rhastalive.services;

import com.livestream.rhastalive.dao.jpa.JpaProductDao;
import com.livestream.rhastalive.model.Product;
import com.livestream.rhastalive.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class ProductTest {

    private static ProductServiceImpl productService;
    private static JpaProductDao jpaProductDao;

    @BeforeAll
    public static void setup(){
        jpaProductDao = mock(JpaProductDao.class);

        productService = new ProductServiceImpl();
        productService.setProductDao(jpaProductDao);
    }


    @Test
    public void productFind(){
        int fakeId = 9999;
        Product fakeCustomer = new Product();
        when(jpaProductDao.findById(fakeId)).thenReturn(fakeCustomer);

        // exercise
        Product product = jpaProductDao.findById(fakeId);

        // verify
        assertEquals(fakeCustomer, product);
    };

    @Test
    public void productActive(){

        List<Product> fakeList = mock(ArrayList.class);

        when(jpaProductDao.findAll()).thenReturn(fakeList);

        //exercise
        List<Product> list = productService.listOfActiveProducts();

        //verify
        assertNotNull(list);
        verify(jpaProductDao, times(1)).findAll();
    }

    @Test
    public void productMerchandising(){

        int fakeId = 9999;

        List<Product> fakeList = mock(ArrayList.class);

        when(jpaProductDao.findAll()).thenReturn(fakeList);

        //exercise
        List<Product> list = productService.listMerchandising(fakeId);

        //verify
        assertNotNull(list);
        verify(jpaProductDao, times(1)).findAll();
    }

    @Test
    public void productAdd(){
        Product product = new Product();

        System.out.println(productService.add(product));
    }

    @Test
    public void productEdit(){
        Product product2 = new Product();

        System.out.println(productService.edit(product2));
    }

    @Test
    public void productRemove(){

        Product fakeProduct = new Product();
        int fakeProductId = 9999;

        when(jpaProductDao.findById(fakeProductId)).thenReturn(fakeProduct);

        //exercise
        productService.remove(fakeProduct);

        //verify
        verify(jpaProductDao, times(1)).delete(fakeProduct.getId());

    }
}
