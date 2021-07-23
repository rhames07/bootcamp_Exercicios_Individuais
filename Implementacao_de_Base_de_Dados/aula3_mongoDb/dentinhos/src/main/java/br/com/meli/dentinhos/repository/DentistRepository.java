package br.com.meli.dentinhos.repository;

import br.com.meli.dentinhos.entity.Dentist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DentistRepository extends MongoRepository<Dentist, Long> {
}
