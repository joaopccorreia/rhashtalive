package com.livestream.rhastalive.services;

import com.livestream.rhastalive.dao.jpa.JpaShowDao;
import com.livestream.rhastalive.model.Show;
import com.livestream.rhastalive.service.ShowServiceImpl;
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
public class ShowTests {

    private static ShowServiceImpl showService;
    private static JpaShowDao jpaShowDao;

    @BeforeAll
    public static void setup(){

        jpaShowDao = mock(JpaShowDao.class);

        showService = new ShowServiceImpl();
        showService.setDao(jpaShowDao);
    }

    @Test
    public void showFind(){
        List<Show> fakeList = mock(ArrayList.class);

        when(jpaShowDao.findAll()).thenReturn(fakeList);

        //exercise
        List<Show> list = showService.findAllShows();

        //verify
        assertNotNull(list);
        verify(jpaShowDao, times(1)).findAll();
    }

    @Test
    public void showFindId(){
        int fakeId = 9999;
        Show fakeShow = new Show();
        when(jpaShowDao.findById(fakeId)).thenReturn(fakeShow);

        // exercise
        Show show = showService.findById(fakeId);

        // verify
        assertEquals(fakeShow, show);;
    }

    @Test
    public void showDelete(){

        Show fakeShow = new Show();
        int fakeShowId = 9999;

        when(showService.findById(fakeShowId)).thenReturn(fakeShow);

        //exercise
        showService.deleteShow(fakeShowId);

        //verify
        verify(jpaShowDao, times(1)).delete(fakeShowId);

        showService.deleteShow(1);
    }

    @Test
    public void saveShow(){
        Show show = new Show();

        showService.saveOrUpdate(show);

    }

}
