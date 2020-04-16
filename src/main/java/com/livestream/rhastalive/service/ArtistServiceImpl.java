package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.jpa.JpaArtistDao;
import com.livestream.rhastalive.model.users.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private JpaArtistDao dao;

    @Autowired
    public void setDao(JpaArtistDao dao) {
        this.dao = dao;
    }

    public List<Artist> findAll() {

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
    public void delete(Integer id) {

        dao.delete(id);
    }
}
