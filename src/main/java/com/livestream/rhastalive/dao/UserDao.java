package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.model.users.User;

public interface UserDao {

    User findByUserName(String username);
}
