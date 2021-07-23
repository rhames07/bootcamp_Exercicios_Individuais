package br.com.meli.dentinhos.controller;

import br.com.meli.dentinhos.entity.Turn;
import br.com.meli.dentinhos.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turn")
public class TurnController {
    private final TurnService turnService;

    @Autowired
    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @GetMapping
    public ResponseEntity<List<Turn>> findAllTurns() {
        List<Turn> turns = turnService.findAllTurns();
        return new ResponseEntity<>(turns, HttpStatus.OK);
    }

    @GetMapping("/dentist/{name}")
    public ResponseEntity<List<Turn>> findByDentistName(@PathVariable String name) {
        List<Turn> turns = turnService.findByDentistName(name);
        return new ResponseEntity<>(turns, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Turn>> findByTurnStatus(
            @PathVariable("status") String status
    ){
        List<Turn> turns = turnService.findByTurnStatus(status);
        return new ResponseEntity<>(turns, HttpStatus.OK);
    }

}
