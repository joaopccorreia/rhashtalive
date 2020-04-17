package com.livestream.rhastalive.dao.jpa;

import com.livestream.rhastalive.dao.Dao;
import com.livestream.rhastalive.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * A generic jpa data access object to be used as a base for concrete jpa service implementations
 * @see Dao
 * @param <T> the model type
 */
public abstract class JpaGenericDao<T extends Model> implements Dao<T> {

    @PersistenceContext
    protected EntityManager em;
    protected Class<T> modelType;

    /**
     * Initializes a new JPA DAO instance given a session manager and a model type
     *
     * @param modelType the model type
     */
    public JpaGenericDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @see Dao#findAll()
     */
    @Override
    public List<T> findAll() {

        return em.createQuery("from " + modelType.getSimpleName(), modelType).getResultList();
    }

    /**
     * @see Dao#findById(Integer)
     */
    @Override
    public T findById(Integer id) {

        return em.find(modelType, id);
    }

    /**
     * @see Dao#saveOrUpdate(Model)
     */
    @Override
    public T saveOrUpdate(T modelObject) {

        return em.merge(modelObject);
    }

    /**
     * @see Dao#delete(Integer)
     */
    @Override
    public void delete(Integer id) {

        em.remove(em.find(modelType, id));
    }

}
