package com.livestream.rhastalive.service;

import com.livestream.rhastalive.model.users.Artist;

import java.util.List;

public interface ArtistService {

    public List<Artist> findAll();

    public Artist findById(Integer id);

    public Artist saveOrUpdate(Artist artist);

    public void delete (Integer id);
}
