package com.meli.dentinhos.service;

import com.meli.dentinhos.dao.PatientDao;
import com.meli.dentinhos.entity.Patient;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dentinhos_unit");
    EntityManager em = factory.createEntityManager();

    PatientDao patientDao = new PatientDao(em);

    public List<Patient> getPatientsFromDate(LocalDate date) {
        return patientDao.getPatientFromDate(date);
    }
}
