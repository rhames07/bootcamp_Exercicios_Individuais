package br.com.meli.dentinhos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "dentists")
public class Dentist {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String address;
    private String dni;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private String codeMp;

    public Dentist(String name, String lastName, String address, String dni, LocalDate birthDate, String phone, String email, String codeMp) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.codeMp = codeMp;
    }
}
