package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.model.ShowModel;
import org.springframework.stereotype.Repository;

@Repository
public class ShowDao extends GenericDao<ShowModel> {

    public ShowDao() {
        super(ShowModel.class);
    }
}

