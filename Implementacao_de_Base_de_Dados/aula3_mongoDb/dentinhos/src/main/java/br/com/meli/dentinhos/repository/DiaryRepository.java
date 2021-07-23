package br.com.meli.dentinhos.repository;

import br.com.meli.dentinhos.entity.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends MongoRepository<Diary, Long> {
}
