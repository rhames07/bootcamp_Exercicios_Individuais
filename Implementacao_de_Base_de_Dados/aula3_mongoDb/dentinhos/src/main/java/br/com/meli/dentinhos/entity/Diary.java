package br.com.meli.dentinhos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "diaries")
public class Diary {
    @Id
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Field(value = "dentist")
    private Dentist dentist;

    public Diary(LocalDateTime startTime, LocalDateTime endTime, Dentist dentist) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dentist = dentist;
    }

    public Diary(LocalDateTime startTime, Dentist dentist) {
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(30);
        this.dentist = dentist;
    }
}
