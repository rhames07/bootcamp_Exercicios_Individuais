package br.com.meli.dentinhos.service;

import br.com.meli.dentinhos.entity.Dentist;
import br.com.meli.dentinhos.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DentistService {
    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public List<Dentist> getDentistsThatHasTwoTurnInSameDay(LocalDate date) {
        return dentistRepository.findDentistsThatHasTwoTurnInSameDay(date);
    }
}
