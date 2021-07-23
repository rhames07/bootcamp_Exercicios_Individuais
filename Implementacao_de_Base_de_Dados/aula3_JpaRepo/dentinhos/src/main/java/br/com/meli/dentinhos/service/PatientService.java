package br.com.meli.dentinhos.service;

import br.com.meli.dentinhos.entity.Patient;
import br.com.meli.dentinhos.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatientsFromDate(LocalDate date) {
        return patientRepository.getPatientFromDate(date);
    }
}
