package br.com.meli.obterdiploma.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Subject {
    @NotNull
    @Length(min=8, message = "Matéria não pode ter menos que 8 caracteres.")
    @Length(max=50, message = "Matéria não deve ter mais que 50 caracteres.")
    @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$", message = "Matéria deve contar apenas letras.")
    private String subject;
    @Min(value = 0, message = "Nota mínima: 0")
    @Max(value = 10, message = "Nota máxima: 10")
    private Double note;

    public Subject() {
    }

    public Subject(String subject, double note) {
        this.subject = subject;
        this.note = note;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }


}
