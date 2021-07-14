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
        return writeDiploma(studentDTO);
    }

    public static double calculateAverage(List<Subject> subjects) {
        List<Double> notes = new ArrayList<>();
        subjects.forEach(subject -> notes.add(subject.getNote()));
        return notes.stream().mapToDouble(n -> n).average().orElse(0.0);
    }

    public static String withHonors(double media) {
        if (media >= 9) return "Você foi aprovado com média " + media;
        return "Você foi reprovado com média " + media;
    }

    public static SubjectDTO writeDiploma(StudentDTO studentDTO){
        double average = calculateAverage(studentDTO.getSubjects());
        String message = withHonors(average);
        return new SubjectDTO(studentDTO, average, message);
    }
}
