package com.livestream.rhastalive.service;

import com.livestream.rhastalive.model.Artist;

import java.util.List;

public interface ArtistService {

    public List<Artist> findAllShows();

    public Artist findById(Integer id);

    public Artist saveOrUpdate(Artist artist);

    public void deleteShow (Integer id);
}
