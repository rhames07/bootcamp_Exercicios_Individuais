package br.com.meli.obterdiploma.service;

import br.com.meli.obterdiploma.dto.StudentDTO;
import br.com.meli.obterdiploma.entity.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void shouldVerifyIfPayloadIsValid() {
        String nomeDoAluno = "Lucas Sousa Farias";
        List<Subject> subjects = new ArrayList<>(List.of(
                new Subject("Matematica", 10),
                new Subject("Portugues", 8),
                new Subject("Física", 9)
        ));
        StudentDTO payload = new StudentDTO(nomeDoAluno, subjects);

        studentService.addAluno(payload);

        Assertions.assertTrue(nomeDoAluno.length() < 50);
        Assertions.assertTrue(nomeDoAluno.length() > 8);
    }
}
