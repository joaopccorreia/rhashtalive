package com.livestream.rhastalive.dao.jpa;

import com.livestream.rhastalive.dao.ShowDao;
import com.livestream.rhastalive.dao.jpa.JpaGenericDao;
import com.livestream.rhastalive.model.Show;
import org.springframework.stereotype.Repository;

@Repository
public class JpaShowDao extends JpaGenericDao<Show> implements ShowDao {

    public JpaShowDao() {
        super(Show.class);
    }
}

