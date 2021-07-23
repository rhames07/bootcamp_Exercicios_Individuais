package com.meli.dentinhos.service;

import com.meli.dentinhos.dao.DentistDao;
import com.meli.dentinhos.entity.Dentist;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

@Service
public class DentistService {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dentinhos_unit");
    EntityManager em = factory.createEntityManager();

    DentistDao dentistDao = new DentistDao(em);

    public List<Dentist> getDentistsThatHasTwoTurnInSameDay(LocalDate date) {
        return dentistDao.getDentistsThatHasTwoTurnInSameDay(date);
    }
}
