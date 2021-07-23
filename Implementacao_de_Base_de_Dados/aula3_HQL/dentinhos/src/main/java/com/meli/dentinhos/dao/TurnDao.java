package com.meli.dentinhos.dao;

import com.meli.dentinhos.entity.Turn;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class TurnDao {

    private final EntityManager em;

    public TurnDao(EntityManager em) {
        this.em = em;
    }

    public void save(Turn turn) {
        em.persist(turn);
    }

    public List<Turn> getTurnsStatusDone() {
        TypedQuery<Turn> turnTypedQuery = em.createQuery(
                "SELECT t FROM Turn t INNER JOIN TurnStatus ts ON ts.id=t.turnStatus.id WHERE ts.name = :status",
                Turn.class);
        turnTypedQuery.setParameter("status", "Concluido");
        return turnTypedQuery.getResultList();
    }

    public List<Turn> getTurnsPendingByDate(LocalDate date) {
        TypedQuery<Turn> turnTypedQuery = em.createQuery(
                "SELECT t FROM Turn t INNER JOIN TurnStatus ts ON ts.id=t.turnStatus.id " +
                        "WHERE ts.name = :status AND t.day = :date",
                Turn.class);
        turnTypedQuery.setParameter("status", "Pendente");
        turnTypedQuery.setParameter("date", date);
        return turnTypedQuery.getResultList();
    }

    public List<Turn> getTurnsStatusRescheduled() {
        TypedQuery<Turn> turnTypedQuery = em.createQuery(
                "SELECT t FROM Turn t INNER JOIN TurnStatus ts ON ts.id=t.turnStatus.id WHERE ts.name = :status",
                Turn.class);
        turnTypedQuery.setParameter("status", "Remarcado");
        return turnTypedQuery.getResultList();
    }

    public List<Turn> getDentistRescheduledTurns(Long id) {
        TypedQuery<Turn> turnTypedQuery = em.createQuery(
                "SELECT t FROM Turn t INNER JOIN TurnStatus ts ON ts.id=t.turnStatus.id " +
                        "INNER JOIN Diary d ON d.id=t.diary.id " +
                        "INNER JOIN Dentist dt ON dt.id=d.dentist.id " +
                        "WHERE dt.id=:id AND ts.name=:status",
                Turn.class);
        turnTypedQuery.setParameter("status", "Remarcado");
        turnTypedQuery.setParameter("id", id);
        return turnTypedQuery.getResultList();
    }
}
