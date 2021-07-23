package br.com.meli.dentinhos.repository;

import br.com.meli.dentinhos.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = "SELECT p FROM Patient p " +
            "INNER JOIN Turn t ON p.id=t.patient.id " +
            "WHERE t.day = :date")
    List<Patient> getPatientFromDate(@Param("date") LocalDate date);
}
