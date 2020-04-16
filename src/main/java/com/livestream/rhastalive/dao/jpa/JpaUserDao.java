package com.livestream.rhastalive.dao.jpa;

import com.livestream.rhastalive.dao.UserDao;
import com.livestream.rhastalive.model.users.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserDao extends JpaGenericDao<User> implements UserDao {

    /**
     * Initializes a new JPA DAO instance given a session manager and a model type
     *
     */
    public JpaUserDao() {
        super(User.class);
    }

    @Override
    public User findByUserName(String username) {
        //(User) em.createQuery("select '*' from " + modelType.getSimpleName() + " where 'userName' = '" + username + "'").getSingleResult()
        return em.find(modelType, 1);
    }
}
