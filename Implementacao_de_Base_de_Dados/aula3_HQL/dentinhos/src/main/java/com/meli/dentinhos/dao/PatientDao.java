package com.meli.dentinhos.dao;

import com.meli.dentinhos.entity.Diary;

import javax.persistence.EntityManager;

public class DiaryDao {

    private final EntityManager em;

    public DiaryDao(EntityManager em) {
        this.em = em;
    }

    public void save(Diary diary) {
        em.persist(diary);
    }
}
