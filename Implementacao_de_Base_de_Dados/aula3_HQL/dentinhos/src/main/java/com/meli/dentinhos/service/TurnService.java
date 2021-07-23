package com.meli.dentinhos.service;

import com.meli.dentinhos.dao.TurnDao;
import com.meli.dentinhos.entity.Turn;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

@Service
public class TurnService {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dentinhos_unit");
    EntityManager em = factory.createEntityManager();

    TurnDao turnDao = new TurnDao(em);

    public List<Turn> getTurnsStatusDone() {
        return turnDao.getTurnsStatusDone();
    }

    public List<Turn> getTurnsPendingByDate(LocalDate date) {
        return turnDao.getTurnsPendingByDate(date);
    }

    public List<Turn> getTurnsStatusRescheduled() {
        return turnDao.getTurnsStatusRescheduled();
    }

    public List<Turn> getDentistRescheduledTurns(Long id) {
        return turnDao.getDentistRescheduledTurns(id);
    }
}
