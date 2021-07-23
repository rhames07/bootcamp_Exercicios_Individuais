package com.meli.dentinhos.dao;

import com.meli.dentinhos.entity.TurnStatus;

import javax.persistence.EntityManager;

public class TurnStatusDao {

    private final EntityManager em;

    public TurnStatusDao(EntityManager em) {
        this.em = em;
    }

    public void save(TurnStatus turnStatus) {
        em.persist(turnStatus);
    }
}
