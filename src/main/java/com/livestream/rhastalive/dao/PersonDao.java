package com.livestream.rhastalive.dao;

import com.livestream.rhastalive.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Person get(Integer id) {
        return entityManager.find(Person.class, id);
    }

    @Transactional(readOnly = true)
    public List<Person> getAll() {
        CriteriaQuery<Person> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public void saveOrUpdate (Person person) {
        entityManager.merge(person);
    }

}

