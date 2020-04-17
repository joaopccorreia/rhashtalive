package com.livestream.rhastalive.service;

import com.livestream.rhastalive.dao.jpa.JpaUserDao;
import com.livestream.rhastalive.model.users.User;
import com.livestream.rhastalive.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecureUserServiceImpl implements UserDetailsService {

    JpaUserDao jpaUserDao;

    @Autowired
    public void setJpaUserDao(JpaUserDao jpaUserDao) {
        this.jpaUserDao = jpaUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return new MyUserDetails(jpaUserDao.findByUserName(username)) {
        };
    }
    
}
