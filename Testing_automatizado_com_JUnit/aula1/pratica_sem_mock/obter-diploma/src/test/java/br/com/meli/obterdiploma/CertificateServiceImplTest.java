package br.com.meli.obterdiploma;

import br.com.meli.obterdiploma.dto.StudentDTO;
import br.com.meli.obterdiploma.dto.SubjectDTO;
import br.com.meli.obterdiploma.entity.Subject;
import br.com.meli.obterdiploma.service.StudentService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CertificateServiceImplTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void shouldPassWhenPayloadIsValid(){
        String name = "Rhames Lima";
        List<Subject> subjectList = new ArrayList<>(List.of(
                new Subject("Matemática", 10),
                new Subject("Português", 9),
                new Subject("Biologia", 9.5)
        ));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(name);
        studentDTO.setSubjects(subjectList);

        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void shouldFailWhenStudentNameIsEmpty(){
        String name = "";
        List<Subject> subjectList = new ArrayList<>(List.of(
                new Subject("Matemática", 10),
                new Subject("Português", 9),
                new Subject("Biologia", 9.5)
        ));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(name);
        studentDTO.setSubjects(subjectList);

        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldReceiveMessageReprovedWhenNoSubjects(){
        String name = "Rhames Lima";
        List<Subject> subjectList = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(name);
        studentDTO.setSubjects(subjectList);

        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenAverageBiggerThenNine(){
        List<Subject> subjectList = new ArrayList<>(List.of(
                new Subject("Matemática", 10),
                new Subject("Português", 9)
        ));
        double average = StudentService.calculateAverage(subjectList);
        assertEquals(9.5, average );
        assertNotEquals(10, average);
    }

    @Test
    public void shouldReturnAverageZeroWhenSubjectListIsEmpty(){
        List<Subject> subjectList = new ArrayList<>();
        double average = StudentService.calculateAverage(subjectList);
        assertEquals(0.0, average );
        assertNotEquals(10, average);
    }

    @Test
    public void shouldReturnWithHonorIfAverageEqualNine(){
        String withHonor = StudentService.withHonors(9.0);
        assertEquals("Você foi aprovado com média 9.0", withHonor);
    }

    @Test
    public void shouldReturnWithHonorIfAverageGreaterThanNine(){
        String withHonor = StudentService.withHonors(9.5);
        assertEquals("Você foi aprovado com média 9.5", withHonor);
    }

    @Test
    public void shouldReturnWithHonorIfAverageLessThanNine(){
        String withHonor = StudentService.withHonors(8.9);
        assertEquals("Você foi reprovado com média 8.9", withHonor);

    }

    @Test
    public void shouldWhiteDiplomaWhenValidStudent(){
        String name = "Rhames Lima";
        List<Subject> subjectList = new ArrayList<>(List.of(
                new Subject("Matemática", 10),
                new Subject("Português", 9),
                new Subject("Biologia", 9.5)
        ));
        StudentDTO studentDTO = new StudentDTO(name, subjectList);
        double average = StudentService.calculateAverage(subjectList);
        String message = StudentService.withHonors(average);
        SubjectDTO expected = new SubjectDTO(studentDTO, average, message);

        SubjectDTO result = StudentService.writeDiploma(studentDTO);
        assertEquals(expected.getStudent(), result.getStudent());
        assertEquals(expected.getAverage(), result.getAverage());
        assertEquals(expected.getMessage(), result.getMessage());
    }

    @Test
    public void shouldWhiteDiplomaWhenStudentHasNoSubjects(){
        String name = "Rhames Lima";
        List<Subject> subjectList = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(name, subjectList);
        double average = StudentService.calculateAverage(subjectList);
        String message = StudentService.withHonors(average);
        SubjectDTO expected = new SubjectDTO(studentDTO, average, message);

        SubjectDTO result = StudentService.writeDiploma(studentDTO);
        assertEquals(expected.getStudent(), result.getStudent());
        assertEquals(expected.getAverage(), result.getAverage());
        assertEquals(expected.getMessage(), result.getMessage());
    }
}
