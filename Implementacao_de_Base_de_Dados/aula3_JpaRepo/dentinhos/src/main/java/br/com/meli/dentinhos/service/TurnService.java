package br.com.meli.dentinhos.service;

import br.com.meli.dentinhos.entity.Turn;
import br.com.meli.dentinhos.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnService {
    private final TurnRepository turnRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    public List<Turn> getTurnsStatusDone() {
        String status = "Concluido";
        return turnRepository.findByTurnStatus_Name(status);
    }

    public List<Turn> getTurnsPendingByDate(LocalDate date) {
        String status = "Pendente";
        return turnRepository.findAllByTurnStatusNameAndDay(status, date);
    }

    public List<Turn> getTurnsStatusRescheduled() {
        String status = "Remarcado";
        return turnRepository.findByTurnStatus_Name(status);
    }

    public List<Turn> getDentistRescheduledTurns(Long id) {
        String status = "Remarcado";
        return turnRepository.findByTurnStatus_NameAndDiary_Dentist_Id(status, id);
    }
}
