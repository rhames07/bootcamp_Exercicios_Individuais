package br.com.meli.obterdiploma.dto;

import br.com.meli.obterdiploma.dao.StudentDAO;
import br.com.meli.obterdiploma.entity.Student;
import br.com.meli.obterdiploma.entity.Subject;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class StudentDTO {
    @NotNull
    @Length(min = 8, message = "Nome não pode ter menos que 8 caracteres.")
    @Length(max = 50, message = "Nome não deve ter mais que 50 caracteres.")
    @Pattern(
            regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$",
            message = "Nome deve conter apenas letras."
    )
    private String name ;
    private List<@Valid Subject> subjects;

    public StudentDTO(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public StudentDTO() {
    }

    public static Student convert(StudentDTO studentDTO) {
        Long id = (long) StudentDAO.getListaDeAlunos().size()+1;
        return new Student(id, studentDTO.getName(), studentDTO.getSubjects());
    }

    public static StudentDTO convert(Student student) {
        return new StudentDTO(student.getName(), student.getSubjects());
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
