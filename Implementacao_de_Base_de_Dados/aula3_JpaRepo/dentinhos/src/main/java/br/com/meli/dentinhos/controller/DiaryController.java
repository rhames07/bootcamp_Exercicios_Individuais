package br.com.meli.dentinhos.controller;

import br.com.meli.dentinhos.entity.Patient;
import br.com.meli.dentinhos.service.DiaryService;
import br.com.meli.dentinhos.service.PatientService;
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
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService diaryService;
    private final PatientService patientService;

    @Autowired
    public DiaryController(DiaryService diaryService, PatientService patientService) {
        this.diaryService = diaryService;
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllTreatedPatients(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Patient> patientList = patientService.getPatientsFromDate(date);
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }
}
