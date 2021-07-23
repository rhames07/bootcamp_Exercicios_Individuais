package com.meli.dentinhos.dao;

import com.meli.dentinhos.entity.Patient;

import javax.persistence.EntityManager;

public class PatientDao {

    private final EntityManager em;

    public PatientDao(EntityManager em) {
        this.em = em;
    }

    public void save(Patient patient) {
        em.persist(patient);
    }
}
