package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.jpa.JpaShowDao;
import com.livestream.rhastalive.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private JpaShowDao dao;

    @Autowired
    public void setDao(JpaShowDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public List<Show> findAllShows() {

        return dao.findAll();
    }

    @Transactional(readOnly = true)
    public Show findById(Integer id) {

        return dao.findById(id);
    }

    @Transactional
    public Show saveOrUpdate(Show show) {
        return dao.saveOrUpdate(show);
    }

    @Transactional
    public void deleteShow (Integer id) {

        dao.delete(id);
    }
}
