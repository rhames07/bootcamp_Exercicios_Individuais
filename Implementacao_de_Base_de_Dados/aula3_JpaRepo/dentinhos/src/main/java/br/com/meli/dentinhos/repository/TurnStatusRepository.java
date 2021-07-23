package br.com.meli.dentinhos.repository;

import br.com.meli.dentinhos.entity.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnStatusRepository extends JpaRepository<TurnStatus, Long> {
}
