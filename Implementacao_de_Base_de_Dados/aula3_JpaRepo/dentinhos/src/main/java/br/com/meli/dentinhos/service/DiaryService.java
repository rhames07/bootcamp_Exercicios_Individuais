package br.com.meli.dentinhos.service;

import br.com.meli.dentinhos.entity.Diary;
import br.com.meli.dentinhos.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public List<Diary> getDentistDiaries(Long id) {
        return diaryRepository.findByDentist_Id(id);
    }
}
