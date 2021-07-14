package br.com.meli.obterdiploma.dto;

import br.com.meli.obterdiploma.entity.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SubjectDTOTest {
    @Test
    public void deveRetornarSucessoParaSubjectsCriadosCorretamente(){
        String nomeDoAluno = "Lucas Sousa Farias";
        List<Subject> subjects = new ArrayList<>(List.of(
                new Subject("Matematica", 10),
                new Subject("Portugues", 8),
                new Subject("Física", 9)
        ));
        StudentDTO student = new StudentDTO(nomeDoAluno, subjects);
        double average = 7.8;
        String message = "passou";
        SubjectDTO subjectDTO = new SubjectDTO(student, average, message);

        Assertions.assertEquals(subjectDTO.getStudent(), student);
        Assertions.assertEquals(subjectDTO.getAverage(), average);
        Assertions.assertEquals(subjectDTO.getMessage(), message);
    }
}
