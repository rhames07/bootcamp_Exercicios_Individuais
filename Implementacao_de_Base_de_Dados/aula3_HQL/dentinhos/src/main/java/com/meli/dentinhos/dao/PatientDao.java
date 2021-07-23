package com.meli.dentinhos.dao;

import com.meli.dentinhos.entity.Patient;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class PatientDao {

    private final EntityManager em;

    public PatientDao(EntityManager em) {
        this.em = em;
    }

    public void save(Patient patient) {
        em.persist(patient);
    }

    public List<Patient> getPatientFromDate(LocalDate date) {
        TypedQuery<Patient> patientTypedQuery = em.createQuery(
                "select p from Patient p inner join Turn t on p.id=t.patient.id where t.day = :date",
                Patient.class);
        patientTypedQuery.setParameter("date", date);
        return patientTypedQuery.getResultList();
    }
}
