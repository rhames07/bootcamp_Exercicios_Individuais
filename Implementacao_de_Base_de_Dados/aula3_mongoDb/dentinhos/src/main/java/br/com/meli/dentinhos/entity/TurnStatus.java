package br.com.meli.dentinhos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(value = "turnStatus")
public class TurnStatus {
    @Id
    private String id;
    private String name;
    private String description;

    public TurnStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
