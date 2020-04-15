package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.model.Artist;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistDao extends GenericDao<Artist> {

    public ArtistDao() {
        super(Artist.class);
    }
}
