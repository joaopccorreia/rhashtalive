package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.dao.jpa.JpaShowDao;
import com.livestream.rhastalive.model.Show;
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
public class JpaShowDaoTest {


    private static JpaShowDao jpaShowDao;
    private static EntityManager em;

    @BeforeAll
    public static void setup(){
        em = mock(EntityManager.class);

        jpaShowDao = new JpaShowDao();
        jpaShowDao.setEm(em);

    }

    @Test
    public void testFindAll(){
        List<Show> mockShow = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);
        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Show.class)).thenReturn(criteriaQuery);
        when(em.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(em.createQuery(anyString(), any(Class.class))).thenReturn(typedQuery);
        when(em.createQuery(any(CriteriaQuery.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockShow);

        // exercise
        List<Show> show = jpaShowDao.findAll();

        // verify
        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockShow, show);

        System.out.println(show);

    }

    @Test
    public void testFindById() {

        // setup
        int fakeId = 9999;
        Show fakeArtist = new Show ();
        when(em.find(Show.class, fakeId)).thenReturn(fakeArtist);

        // exercise
        Show show = jpaShowDao.findById(fakeId);

        // verify
        verify(em, times(1)).find(Show.class, fakeId);
        assertEquals(fakeArtist, show);

        System.out.println(show);

    }
    @Test
    public void testSaveOrUpdate() {

        // setup
        Show fakeShow = new Show();
        when(em.merge(any(Show.class))).thenReturn(fakeShow);

        // exercise
        Show show = jpaShowDao.saveOrUpdate(fakeShow);

        // verify
        verify(em, times(1)).merge(any(Show.class));
        assertEquals(fakeShow, show);

    }

    @Test
    public void testDelete() {

        // setup
        int fakeId = 9999;
        Show fakeShow = new Show();

        when(em.find(Show.class, fakeId)).thenReturn(fakeShow);

        // exercise
        jpaShowDao.delete(fakeId);

        // verify
        verify(em, times(1)).remove(fakeShow);

    }

}
