package com.meli.dentinhos.controller;

import com.meli.dentinhos.service.PopulateDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/populate-database")
public class PopulateDatabaseController {

    private final PopulateDatabaseService service;

    @Autowired
    public PopulateDatabaseController(PopulateDatabaseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> populateDatabase() {
        service.populateDatabase();
        return ResponseEntity.ok().build();
    }
}
