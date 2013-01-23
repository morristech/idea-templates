package com.springapp.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findByName(String name) {
        return em.createQuery("from com.springapp.data.User where name like :name").
                setParameter("name", "%" + name + "%").getResultList();
    }
}
