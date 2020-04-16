package com.livestream.rhastalive.dao;


import com.livestream.rhastalive.dao.jpa.JpaArtistDao;
import com.livestream.rhastalive.model.users.Artist;
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
import static org.mockito.Mockito.times;

@SpringBootTest
public class JpaArtistDaoTest {

    private static JpaArtistDao artistDao;
    private static EntityManager em;

    @BeforeAll
    public static void setup(){
        em = mock(EntityManager.class);

        artistDao = new JpaArtistDao();
        artistDao.setEm(em);

    }

    @Test
    public void testFindAll(){
        List<Artist> mockartists = new ArrayList<>();
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        TypedQuery typedQuery = mock(TypedQuery.class);
        when(em.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Artist.class)).thenReturn(criteriaQuery);
        when(em.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(em.createQuery(anyString(), any(Class.class))).thenReturn(typedQuery);
        when(em.createQuery(any(CriteriaQuery.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(mockartists);

        // exercise
        List<Artist> artists = artistDao.findAll();

        // verify
        verify(typedQuery, times(1)).getResultList();
        assertEquals(mockartists, artists);

        System.out.println(artists);

    }

    @Test
    public void testFindById() {

        // setup
        int fakeId = 9999;
        Artist fakeArtist = new Artist();
        when(em.find(Artist.class, fakeId)).thenReturn(fakeArtist);

        // exercise
        Artist artist = artistDao.findById(fakeId);

        // verify
        verify(em, times(1)).find(Artist.class, fakeId);
        assertEquals(fakeArtist, artist);

        System.out.println(artist);

    }
    @Test
    public void testSaveOrUpdate() {

        // setup
        Artist fakeArtist = new Artist();
        when(em.merge(any(Artist.class))).thenReturn(fakeArtist);

        // exercise
        Artist artist = artistDao.saveOrUpdate(fakeArtist);

        // verify
        verify(em, times(1)).merge(any(Artist.class));
        assertEquals(fakeArtist, artist);

    }

    @Test
    public void testDelete() {

        // setup
        int fakeId = 9999;
        Artist fakeArtist = new Artist();

        when(em.find(Artist.class, fakeId)).thenReturn(fakeArtist);

        // exercise
        artistDao.delete(fakeId);

        // verify
        verify(em, times(1)).remove(fakeArtist);

    }


}
