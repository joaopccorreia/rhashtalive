package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.ShowDao;
import com.livestream.rhastalive.model.ShowModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShowService {

    private ShowDao dao;

    public List<ShowModel> findAllShows() {

        return dao.findAllShows();
    }

    public ShowModel findById(Integer id) {

        return dao.findById(id);
    }

    @Transactional
    public ShowModel saveOrUpdate(ShowModel showModel) {

        return dao.saveOrUpdate(showModel);
    }

    @Transactional
    public void deleteShow (ShowModel showModel) {

        dao.deleteShow(showModel);
    }
}
