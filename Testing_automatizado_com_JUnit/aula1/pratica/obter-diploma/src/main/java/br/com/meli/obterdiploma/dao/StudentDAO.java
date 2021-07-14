package br.com.meli.obterdiploma.dao;

import br.com.meli.obterdiploma.entity.Student;
import br.com.meli.obterdiploma.exception.StudentNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAO {

    private static List<Student> listaDeStudents = new ArrayList<>();

    public static List<Student> getListaDeAlunos() {
        return listaDeStudents;
    }

    public static void setListaDeAlunos(List<Student> listaDeStudents) {
        StudentDAO.listaDeStudents = listaDeStudents;
    }

    public Long addAluno(Student student){
        listaDeStudents.add(student);
        return student.getId();
    }

    public Student getAluno(Long id) {
        Optional<Student> alunoOptional = listaDeStudents.stream().
                filter(a -> a.getId().equals(id)).findFirst();

        if (alunoOptional.isEmpty())
            throw new StudentNotFoundException("Aluno não encontrado.");

        return alunoOptional.get();
    }

}
