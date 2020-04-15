package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.dao.jpa.JpaGenericDao;
import com.livestream.rhastalive.model.Show;
import org.springframework.stereotype.Repository;

@Repository
public class ShowDao extends JpaGenericDao<Show> {

    public ShowDao() {
        super(Show.class);
    }
}

