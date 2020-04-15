package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.jpa.ShowDao;
import com.livestream.rhastalive.model.ShowModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private ShowDao dao;

    public List<ShowModel> findAllShows() {

        dao.findAllShows();
    }

    public ShowModel findById(Integer id) {

        dao.findById(id);
    }

    public void addShow (ShowModel showModel) {

        dao.addShow(showModel);
    }

    public void editShow (ShowModel showModel) {

        dao.editShow(showModel);
    }

    public void deleteShow (ShowModel showModel) {

        dao.deleteShow(showModel);
    }
}
