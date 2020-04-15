package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.model.Show;
import org.springframework.stereotype.Repository;

@Repository
public class ShowDao extends GenericDao<Show> {

    public ShowDao() {
        super(Show.class);
    }
}

