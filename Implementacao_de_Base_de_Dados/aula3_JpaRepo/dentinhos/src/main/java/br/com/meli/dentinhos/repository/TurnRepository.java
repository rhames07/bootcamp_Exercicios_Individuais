package br.com.meli.dentinhos.repository;

import br.com.meli.dentinhos.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {

    List<Turn> findAllByTurnStatusNameAndDay(String status, LocalDate date);
    List<Turn> findByTurnStatus_Name(String status);
    List<Turn> findByTurnStatus_NameAndDiary_Dentist_Id(String status, Long id);
}
