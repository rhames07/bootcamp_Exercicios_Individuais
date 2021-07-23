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

    public List<Turn> findAllTurns() {
        return turnRepository.findAll();
    }

    public List<Turn> findByDentistName(String name) {
        return turnRepository.findTurnsByDiaryDentistName(name);
    }

    public List<Turn> findByTurnStatus(String status) {
        return turnRepository.findTurnsByTurnStatusName(status);
    }
}
