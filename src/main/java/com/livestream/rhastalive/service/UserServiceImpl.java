package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.jpa.JpaUserDao;
import com.livestream.rhastalive.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private JpaUserDao dao;

    @Autowired
    public void setDao(JpaUserDao dao) {
        this.dao = dao;
    }


    @Transactional(readOnly = true)
    public User findByUserName(String userName) {

        return dao.findByUserName(userName);
    }

    @Transactional
    public User saveOrUpdate(User user) {
        return dao.saveOrUpdate(user);
    }

    @Transactional
    public void deleteShow (String userName) {

        dao.delete(userName);
    }
}
