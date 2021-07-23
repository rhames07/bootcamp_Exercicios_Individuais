package br.com.meli.dentinhos.repository;

import br.com.meli.dentinhos.entity.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends MongoRepository<Turn, Long> {
    List<Turn> findTurnsByDiaryDentistName(String name);
    List<Turn> findTurnsByTurnStatusName(String status);
}
