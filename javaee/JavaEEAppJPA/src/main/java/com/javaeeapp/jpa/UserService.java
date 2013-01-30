package com.javaeeapp.jpa;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Stateful
public class UserService {
    @PersistenceContext(unitName = "defaultPersistenceUnit", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(User user) {
        em.persist(user);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<User> findByName(String name) {
        return em.createQuery("from com.javaeeapp.jpa.User where name like :name").
                setParameter("name", "%" + name + "%").getResultList();
    }
}
