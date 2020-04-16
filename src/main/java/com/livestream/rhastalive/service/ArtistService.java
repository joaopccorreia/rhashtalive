package com.livestream.rhastalive.service;

import java.util.List;

public interface ArtistService {

    public List<Artist> findAll();

    public Artist findById(Integer id);

    public Artist saveOrUpdate(Artist artist);

    public void delete (Integer id);
}
