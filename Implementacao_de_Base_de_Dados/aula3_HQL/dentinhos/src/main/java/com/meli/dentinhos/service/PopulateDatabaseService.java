package com.meli.dentinhos.service;

import com.meli.dentinhos.dao.*;
import com.meli.dentinhos.entity.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PopulateDatabaseService {

    public void populateDatabase() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dentinhos_unit");
        EntityManager em = factory.createEntityManager();

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

        try {
            em.getTransaction().begin();

            DentistDao dentistDao = new DentistDao(em);
            dentistDao.save(dentist1);
            dentistDao.save(dentist2);
            dentistDao.save(dentist3);

            DiaryDao diaryDao = new DiaryDao(em);
            diaryDao.save(diary1);
            diaryDao.save(diary2);
            diaryDao.save(diary3);
            diaryDao.save(diary4);

            PatientDao patientDao = new PatientDao(em);
            patientDao.save(patient1);
            patientDao.save(patient2);

            TurnStatusDao turnStatusDao = new TurnStatusDao(em);
            turnStatusDao.save(turnStatusDone);
            turnStatusDao.save(turnStatusCancelled);
            turnStatusDao.save(turnStatusPending);
            turnStatusDao.save(turnStatusRescheduled);

            TurnDao turnDao = new TurnDao(em);
            turnDao.save(turn1);
            turnDao.save(turn2);
            turnDao.save(turn3);
            turnDao.save(turn4);

            UserDao userDao = new UserDao(em);
            userDao.save(user1);
            userDao.save(user2);
            userDao.save(user3);

            em.getTransaction().commit();
            em.clear();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
