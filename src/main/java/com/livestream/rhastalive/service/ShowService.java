package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.ShowDao;
import com.livestream.rhastalive.model.Show;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ShowService {

    private ShowDao dao;

    public List<Show> findAllShows() {

        return dao.findAll();
    }

    public Show findById(Integer id) {

        return dao.findById(id);
    }

    public Show saveOrUpdate(Show show) {
        return dao.saveOrUpdate(show);
    }

    @Transactional
    public void deleteShow (Integer id) {

        dao.delete(id);
    }
}
