package br.com.meli.dentinhos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String last_name;
    private String address;
    private String dni;
    private LocalDate birth_date;
    private String phone;
    private String email;
    private String code_mp;

    public Dentist(String name, String last_name, String address, String dni, LocalDate birth_date, String phone, String email, String code_mp) {
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.dni = dni;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
        this.code_mp = code_mp;
    }
}
