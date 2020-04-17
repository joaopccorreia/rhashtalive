package com.livestream.rhastalive.dao.jpa;

import com.livestream.rhastalive.dao.UserDao;
import com.livestream.rhastalive.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaUserDao implements UserDao {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * Initializes a new JPA DAO instance given a session manager and a model type
     *
     */
    /*public JpaUserDao() {
        super(User.class);
    }*/

    @Override
    public User findByUserName(String username) {

        //return (User) em.createQuery("select '*' from " + modelType.getSimpleName() + " where 'userName' = '" + username + "'").getSingleResult();
        return em.find(User.class, username);
    }

    @Override
    public User saveOrUpdate(User user) {
        return em.merge(user);
    }

    @Override
    public void delete(String userName) {
        em.remove(findByUserName(userName));
    }
}
