package com.livestream.rhastalive.service;

import com.livestream.rhastalive.model.Show;

import java.util.List;

public interface ShowService {

    public List<Show> findAllShows();

    public Show findById(Integer id);

    public Show saveOrUpdate(Show show);

    public void deleteShow (Integer id);
}
