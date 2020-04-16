package com.livestream.rhastalive.dao.jpa;

import com.livestream.rhastalive.dao.ArtistDao;
import com.livestream.rhastalive.model.users.Artist;
import org.springframework.stereotype.Repository;

@Repository
public class JpaArtistDao extends JpaGenericDao<Artist> implements ArtistDao {

    public JpaArtistDao() {
        super(Artist.class);
    }
}
