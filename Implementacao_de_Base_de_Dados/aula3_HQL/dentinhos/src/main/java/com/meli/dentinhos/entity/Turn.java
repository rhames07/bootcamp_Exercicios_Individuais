package com.meli.dentinhos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate day;
    @ManyToOne
    private Diary diary;
    @ManyToOne
    private TurnStatus turnStatus;
    @ManyToOne
    private Patient patient;

    public Turn(LocalDate day, Diary diary, TurnStatus turnStatus, Patient patient) {
        this.day = day;
        this.diary = diary;
        this.turnStatus = turnStatus;
        this.patient = patient;
    }
}
