package br.com.meli.obterdiploma.service;

import br.com.meli.obterdiploma.dao.StudentDAO;
import br.com.meli.obterdiploma.dto.StudentDTO;
import br.com.meli.obterdiploma.dto.SubjectDTO;
import br.com.meli.obterdiploma.entity.Student;
import br.com.meli.obterdiploma.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Long addAluno(StudentDTO studentDTO) {
        Student student = StudentDTO.convert(studentDTO);
        return studentDAO.addAluno(student);
    }

    public Student getAluno(Long id) {
        return studentDAO.getAluno(id);
    }

    public SubjectDTO getResultado(Long id) {
        Student student = studentDAO.getAluno(id);
        StudentDTO studentDTO = StudentDTO.convert(student);
        List<Double> notas = new ArrayList<>();

        List<Subject> subjects = student.getSubjects();
        subjects.forEach(a -> notas.add(a.getNote()));

        double mediaFinal = 0;
        mediaFinal += notas.stream().mapToDouble(n -> n).sum();
        mediaFinal = mediaFinal/notas.size();

        String mensagem = "Sua média foi de " + mediaFinal;

        return new SubjectDTO(studentDTO, mediaFinal, mensagem);
    }
}
