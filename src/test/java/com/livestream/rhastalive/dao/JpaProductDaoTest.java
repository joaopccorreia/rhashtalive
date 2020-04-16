package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.dao.jpa.JpaProductDao;
import com.livestream.rhastalive.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class JpaProductDaoTest {

    private static JpaProductDao productDao;
    private static EntityManager em;

    @BeforeAll
    public static void setup(){
        em = mock(EntityManager.class);

        productDao = new JpaProductDao();
        productDao.setEm(em);

    }

    @Test
    public void testFindAll(){
        List<Product> mockProduct = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);
        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Product.class)).thenReturn(criteriaQuery);
        when(em.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(em.createQuery(anyString(), any(Class.class))).thenReturn(typedQuery);
        when(em.createQuery(any(CriteriaQuery.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockProduct);

        // exercise
        List<Product> artists = productDao.findAll();

        // verify
        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockProduct, artists);

        System.out.println(artists);

    }

    @Test
    public void testFindById() {

        // setup
        int fakeId = 9999;
        Product fakeProduct = new Product();
        when(em.find(Product.class, fakeId)).thenReturn(fakeProduct);

        // exercise
        Product product = productDao.findById(fakeId);

        // verify
        verify(em, times(1)).find(Product.class, fakeId);
        assertEquals(fakeProduct, product);

        System.out.println(product);

    }
    @Test
    public void testSaveOrUpdate() {

        // setup
        Product fakeProduct = new Product();
        when(em.merge(any(Product.class))).thenReturn(fakeProduct);

        // exercise
        Product product = productDao.saveOrUpdate(fakeProduct);

        // verify
        verify(em, times(1)).merge(any(Product.class));
        assertEquals(fakeProduct, product);

    }

    @Test
    public void testDelete() {

        // setup
        int fakeId = 9999;
        Product fakeProduct = new Product();

        when(em.find(Product.class, fakeId)).thenReturn(fakeProduct);

        // exercise
        productDao.delete(fakeId);

        // verify
        verify(em, times(1)).remove(fakeProduct);

    }

    @Test
    public void testFindAllActive(){

    }


}

