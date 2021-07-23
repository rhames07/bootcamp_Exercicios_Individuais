package com.meli.dentinhos.controller;

import com.meli.dentinhos.entity.Turn;
import com.meli.dentinhos.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/done")
    public ResponseEntity<List<Turn>> getTurnsStatusDone(){
        List<Turn> turnList = turnService.getTurnsStatusDone();
        return new ResponseEntity<>(turnList, HttpStatus.OK);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Turn>> getTurnsPendingByDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        List<Turn> turnList = turnService.getTurnsPendingByDate(date);
        return new ResponseEntity<>(turnList, HttpStatus.OK);
    }

    @GetMapping("/rescheduled")
    public ResponseEntity<List<Turn>> getTurnsStatusRescheduled(){
        List<Turn> turnList = turnService.getTurnsStatusRescheduled();
        return new ResponseEntity<>(turnList, HttpStatus.OK);
    }
}
