package com.meli.dentinhos.controller;

import com.meli.dentinhos.entity.Dentist;
import com.meli.dentinhos.entity.Diary;
import com.meli.dentinhos.entity.Turn;
import com.meli.dentinhos.service.DentistService;
import com.meli.dentinhos.service.DiaryService;
import com.meli.dentinhos.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    private final DentistService dentistService;
    private final DiaryService diaryService;
    private final TurnService turnService;

    @Autowired
    public DentistController(DentistService dentistService, DiaryService diaryService, TurnService turnService) {
        this.dentistService = dentistService;
        this.diaryService = diaryService;
        this.turnService = turnService;
    }

    @GetMapping("/two-turns")
    public ResponseEntity<List<Dentist>> getDentistsThatHasTwoTurnInSameDay(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ){
        List<Dentist> dentistList = dentistService.getDentistsThatHasTwoTurnInSameDay(date);
        return new ResponseEntity<>(dentistList, HttpStatus.OK);
    }

    @GetMapping("/{id}/diary")
    public ResponseEntity<List<Diary>> getDentistDiaries(@PathVariable Long id){
        List<Diary> diaryList = diaryService.getDentistDiaries(id);
        return new ResponseEntity<>(diaryList, HttpStatus.OK);
    }

    @GetMapping("/{id}/rescheduled")
    public ResponseEntity<List<Turn>> getDentistRescheduledTurns(@PathVariable Long id){
        List<Turn> turnList = turnService.getDentistRescheduledTurns(id);
        return new ResponseEntity<>(turnList, HttpStatus.OK);
    }
}
