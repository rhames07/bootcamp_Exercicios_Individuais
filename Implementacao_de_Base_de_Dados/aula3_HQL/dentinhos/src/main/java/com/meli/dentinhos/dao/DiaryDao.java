package com.meli.dentinhos.dao;

import com.meli.dentinhos.entity.Diary;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DiaryDao {

    private final EntityManager em;

    public DiaryDao(EntityManager em) {
        this.em = em;
    }

    public void save(Diary diary) {
        em.persist(diary);
    }

    public List<Diary> getDentistDiaries(Long id) {
        TypedQuery<Diary> diaryTypedQuery = em.createQuery(
                "SELECT d FROM Diary d INNER JOIN Dentist dt ON d.dentist.id=dt.id " +
                        "WHERE d.dentist.id=:id",
                Diary.class);
        diaryTypedQuery.setParameter("id", id);
        return diaryTypedQuery.getResultList();
    }
}
