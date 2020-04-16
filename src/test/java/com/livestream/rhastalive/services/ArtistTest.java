package com.livestream.rhastalive.services;


import com.livestream.rhastalive.dao.jpa.JpaArtistDao;
import com.livestream.rhastalive.model.users.Artist;
import com.livestream.rhastalive.service.ArtistServiceImpl;
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
public class ArtistTest {

    private static ArtistServiceImpl artistService;
    private static JpaArtistDao artistDao;

    @BeforeAll()
    public static void setup(){
    artistDao = mock(JpaArtistDao.class);

        artistService = new ArtistServiceImpl();
        artistService.setDao(artistDao);


    }

    @Test
    public void artistFind(){

        int fakeId = 9999;
        Artist fakeartist = new Artist();
        when(artistDao.findById(fakeId)).thenReturn(fakeartist);

        // exercise
        Artist artist = artistService.findById(fakeId);

        // verify
        assertEquals(fakeartist, artist);

    }

    @Test
    public void artistFindAny(){

        List<Artist> fakeList = mock(ArrayList.class);

        when(artistDao.findAll()).thenReturn(fakeList);

        //exercise
        List<Artist> list = artistService.findAll();

        //verify
        assertNotNull(list);
        verify(artistDao, times(1)).findAll();
    }

    @Test
    public void artistDelete(){

        Artist fakeArtist = new Artist();
        int fakeArtistId = 9999;

        when(artistDao.findById(fakeArtistId)).thenReturn(fakeArtist);

        //exercise
        artistService.delete(fakeArtistId);

        //verify
        verify(artistDao, times(1)).delete(fakeArtistId);

        artistService.delete(1);
    }

    @Test
    public void setArtist(){

        Artist artist1 = new Artist();

        artistService.saveOrUpdate(artist1);
    }
}
