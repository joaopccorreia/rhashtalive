package com.livestream.rhastalive.dao.jpa;

import com.livestream.rhastalive.model.Show;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShowDao {

    public List<Show> findAllShows() {
        return null;
    }

    public Show findById(Integer id) {
        return null;
    }

    public void addShow (Show showModel) {}

    public void editShow (Show showModel) {}

    public void deleteShow (Show showModel) { }


    public Show saveOrUpdate(Show showModel) {
        return null;
    }

    public void delete(Integer id) { }
}
