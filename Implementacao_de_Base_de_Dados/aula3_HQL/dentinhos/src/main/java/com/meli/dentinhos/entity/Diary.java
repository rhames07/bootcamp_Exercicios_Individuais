package com.meli.dentinhos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    @ManyToOne
    private Dentist dentist;

    public Diary(LocalDateTime start_time, LocalDateTime end_time, Dentist dentist) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.dentist = dentist;
    }

    public Diary(LocalDateTime start_time, Dentist dentist) {
        this.start_time = start_time;
        this.end_time = start_time.plusMinutes(30);
        this.dentist = dentist;
    }
}
