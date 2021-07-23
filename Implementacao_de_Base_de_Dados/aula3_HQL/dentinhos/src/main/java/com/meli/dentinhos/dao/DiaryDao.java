package com.meli.dentinhos.dao;

import com.meli.dentinhos.entity.Dentist;

import javax.persistence.EntityManager;

public class DentistDao {

    private final EntityManager em;

    public DentistDao(EntityManager em) {
        this.em = em;
    }

    public void save(Dentist dentist) {
        em.persist(dentist);
    }
}
