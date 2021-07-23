package com.meli.dentinhos.controller;

import com.meli.dentinhos.entity.Dentist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

@RestController
@RequestMapping("/dentist")
public class UserController {
    @GetMapping
    public ResponseEntity<Dentist> addDentist() {
        Dentist dentist = new Dentist(
                "Rhames",
                "Lima",
                "Alameda Santos",
                "001",
                LocalDate.of(1997, 10,30),
                "11999410923",
                "rhames@mail.com",
                "321");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dentinhos_unit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(dentist);
        em.getTransaction().commit();
        em.clear();
        return new ResponseEntity<>(dentist, HttpStatus.OK);
    }
}
