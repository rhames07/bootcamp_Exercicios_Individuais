package br.com.meli.dentinhos.repository;

import br.com.meli.dentinhos.entity.TurnStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnStatusRepository extends MongoRepository<TurnStatus, Long> {
}
