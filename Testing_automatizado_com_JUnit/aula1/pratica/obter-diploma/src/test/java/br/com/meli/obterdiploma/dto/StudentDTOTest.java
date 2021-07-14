package br.com.meli.obterdiploma.dto;

import br.com.meli.obterdiploma.entity.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentDTOTest {
    @Test
    public void deveRetornarSucessoParaStudentsCriadosCorretamente(){
        String nomeDoAluno = "Lucas Sousa Farias";
        List<Subject> subjects = new ArrayList<>(List.of(
                new Subject("Matematica", 10),
                new Subject("Portugues", 8),
                new Subject("Física", 9)
        ));
        StudentDTO studentDTO = new StudentDTO(nomeDoAluno, subjects);
        Assertions.assertEquals(studentDTO.getName(), nomeDoAluno);
        Assertions.assertEquals(studentDTO.getSubjects(), subjects);
    }
}
