package br.com.meli.dentinhos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "turns")
public class Turn {
    @Id
    private String id;
    private LocalDate day;
    @Field(value = "diary")
    private Diary diary;
    @Field(value = "status")
    private TurnStatus turnStatus;
    @Field(value = "patient")
    private Patient patient;

    public Turn(LocalDate day, Diary diary, TurnStatus turnStatus, Patient patient) {
        this.day = day;
        this.diary = diary;
        this.turnStatus = turnStatus;
        this.patient = patient;
    }
}
