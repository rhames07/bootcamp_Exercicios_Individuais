package br.com.meli.obterdiploma.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class Student {

    private Long id;
    @NotNull
    @Length(min = 8, message = "Nome não pode ter menos que 8 caracteres.")
    @Length(max = 50, message = "Nome não deve ter mais que 50 caracteres.")
    @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")
    private String name;
    private List<Subject> subjects;

    public Student() {
    }

    public Student(Long id, String name, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
