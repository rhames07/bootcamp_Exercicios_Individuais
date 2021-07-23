package com.meli.dentinhos.dao;

import com.meli.dentinhos.entity.Dentist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class DentistDao {

    private final EntityManager em;

    public DentistDao(EntityManager em) {
        this.em = em;
    }

    public void save(Dentist dentist) {
        em.persist(dentist);
    }

    public List<Dentist> getDentistsThatHasTwoTurnInSameDay(LocalDate date) {
        TypedQuery<Dentist> dentistTypedQuery = em.createQuery(
                "SELECT d FROM Dentist d INNER JOIN Diary di ON d.id=di.dentist.id INNER JOIN Turn t ON di.id=t.diary.id WHERE t.day= :date GROUP BY t.day, d.id HAVING COUNT(t.id) >= 2",
                Dentist.class);
        dentistTypedQuery.setParameter("date", date);
        return dentistTypedQuery.getResultList();
    }
}
