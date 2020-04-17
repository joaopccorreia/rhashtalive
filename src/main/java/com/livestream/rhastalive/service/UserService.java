package com.livestream.rhastalive.service;

import com.livestream.rhastalive.model.users.User;

public interface UserService {

    public User findByUserName(String userName);

    public User saveOrUpdate(User user);

    public void deleteShow (String userName);
}
