package br.com.meli.dentinhos.repository;

import br.com.meli.dentinhos.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByDentist_Id(Long id);
}
