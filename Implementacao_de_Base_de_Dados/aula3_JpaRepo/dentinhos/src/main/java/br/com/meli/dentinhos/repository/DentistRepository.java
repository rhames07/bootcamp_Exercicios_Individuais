package br.com.meli.dentinhos.repository;

import br.com.meli.dentinhos.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    @Query(value = "SELECT d FROM Dentist d " +
            "INNER JOIN Diary di ON d.id=di.dentist.id " +
            "INNER JOIN Turn t ON di.id=t.diary.id " +
            "WHERE t.day= :date " +
            "GROUP BY t.day, d.id HAVING COUNT(t.id) >= 2")
    List<Dentist> findDentistsThatHasTwoTurnInSameDay(@Param("date") LocalDate date);
}
