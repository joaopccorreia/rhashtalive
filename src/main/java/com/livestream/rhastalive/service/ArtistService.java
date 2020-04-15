package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.ArtistDao;
import com.livestream.rhastalive.model.Artist;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ArtistService {

    private ArtistDao dao;

    public List<Artist> findAllShows() {

        return dao.findAll();
    }

    public Artist findById(Integer id) {

        return dao.findById(id);
    }

    @Transactional
    public Artist saveOrUpdate(Artist artist) {

        return dao.saveOrUpdate(artist);
    }

    @Transactional
    public void deleteShow (Integer id) {

        dao.delete(id);
    }
}
