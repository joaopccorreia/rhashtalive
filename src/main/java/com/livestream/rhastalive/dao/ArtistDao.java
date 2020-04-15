package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.dao.jpa.JpaGenericDao;
import com.livestream.rhastalive.model.Artist;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistDao extends JpaGenericDao<Artist> {

    public ArtistDao() {
        super(Artist.class);
    }
}
