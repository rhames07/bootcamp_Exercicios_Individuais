package com.meli.dentinhos.service;

import com.meli.dentinhos.dao.DiaryDao;
import com.meli.dentinhos.entity.Diary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class DiaryService {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dentinhos_unit");
    EntityManager em = factory.createEntityManager();

    DiaryDao diaryDao = new DiaryDao(em);

    public List<Diary> getDentistDiaries(Long id) {
        return diaryDao.getDentistDiaries(id);
    }
}
