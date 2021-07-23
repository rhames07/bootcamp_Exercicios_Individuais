package com.meli.dentinhos.dao;

import com.meli.dentinhos.entity.User;

import javax.persistence.EntityManager;

public class UserDao {

    private final EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        em.persist(user);
    }
}
