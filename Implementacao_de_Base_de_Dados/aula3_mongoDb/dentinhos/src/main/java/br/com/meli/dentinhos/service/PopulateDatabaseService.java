package br.com.meli.dentinhos.service;

import br.com.meli.dentinhos.entity.*;
import br.com.meli.dentinhos.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PopulateDatabaseService {
    private final DentistRepository dentistRepository;
    private final DiaryRepository diaryRepository;
    private final PatientRepository patientRepository;
    private final TurnRepository turnRepository;
    private final TurnStatusRepository turnStatusRepository;
    private final UserRepository userRepository;

    public PopulateDatabaseService(DentistRepository dentistRepository, DiaryRepository diaryRepository, PatientRepository patientRepository, TurnRepository turnRepository, TurnStatusRepository turnStatusRepository, UserRepository userRepository) {
        this.dentistRepository = dentistRepository;
        this.diaryRepository = diaryRepository;
        this.patientRepository = patientRepository;
        this.turnRepository = turnRepository;
        this.turnStatusRepository = turnStatusRepository;
        this.userRepository = userRepository;
    }

    public void populateDatabase() {

        Dentist dentist1 = new Dentist(
                "Luiz",
                "Lima",
                "Alameda Santos",
                "001",
                LocalDate.of(1997, 10,20),
                "11999992323",
                "luiz@mail.com",
                "321");

        Dentist dentist2 = new Dentist(
                "Ricardo",
                "Felipe",
                "R. das Dores",
                "112",
                LocalDate.of(1983, 10,30),
                "11999992235",
                "ric@mail.com",
                "111");

        Dentist dentist3 = new Dentist(
                "Caio",
                "José",
                "R. Laranjas",
                "342",
                LocalDate.of(1999, 5,10),
                "11999972235",
                "caio@mail.com",
                "632");

        Diary diary1 = new Diary(
                LocalDateTime.of(2021, 7, 22, 10, 0, 0), dentist1);

        Diary diary2 = new Diary(
                LocalDateTime.of(2021, 7, 22, 11, 0, 0), dentist2);

        Diary diary3 = new Diary(
                LocalDateTime.of(2021, 7, 22, 11, 30, 0), dentist2);

        Diary diary4 = new Diary(
                LocalDateTime.of(2021, 7, 22, 12, 0, 0), dentist2);

        Patient patient1 = new Patient(
                "Caio",
                "Ricardo",
                "Alameda Jaú",
                "393",
                LocalDate.of(1995, 3,10),
                "11999322235",
                "caior@mail.com");

        Patient patient2 = new Patient(
                "Pedro",
                "Silva",
                "Alameda Franca",
                "421",
                LocalDate.of(2002, 7,15),
                "11999322299",
                "pedro@mail.com");

        TurnStatus turnStatusDone = new TurnStatus("Concluido", "Atendimento foi concluido.");
        TurnStatus turnStatusCancelled = new TurnStatus("Cancelado", "Atendimento foi cancelado.");
        TurnStatus turnStatusPending = new TurnStatus("Pendente", "Atendimento foi pendente.");
        TurnStatus turnStatusRescheduled = new TurnStatus("Remarcado", "Atendimento foi remarcado.");

        Turn turn1 = new Turn(LocalDate.now(), diary1, turnStatusDone, patient1);
        Turn turn2 = new Turn(LocalDate.now(), diary2, turnStatusPending, patient2);
        Turn turn3 = new Turn(LocalDate.now(), diary3, turnStatusPending, patient2);
        Turn turn4 = new Turn(LocalDate.now(), diary4, turnStatusRescheduled, patient2);

        User user1 = new User("joserocha01", "password", "1");
        User user2 = new User("marcoss02", "password", "2");
        User user3 = new User("limasx", "password", "1");

        dentistRepository.save(dentist1);
        dentistRepository.save(dentist2);
        dentistRepository.save(dentist3);

        diaryRepository.save(diary1);
        diaryRepository.save(diary2);
        diaryRepository.save(diary3);
        diaryRepository.save(diary4);

        patientRepository.save(patient1);
        patientRepository.save(patient2);

        turnStatusRepository.save(turnStatusDone);
        turnStatusRepository.save(turnStatusCancelled);
        turnStatusRepository.save(turnStatusPending);
        turnStatusRepository.save(turnStatusRescheduled);

        turnRepository.save(turn1);
        turnRepository.save(turn2);
        turnRepository.save(turn3);
        turnRepository.save(turn4);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
