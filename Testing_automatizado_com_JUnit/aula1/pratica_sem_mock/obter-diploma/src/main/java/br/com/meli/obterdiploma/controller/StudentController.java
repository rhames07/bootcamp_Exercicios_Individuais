package br.com.meli.obterdiploma.controller;

import br.com.meli.obterdiploma.dto.StudentDTO;
import br.com.meli.obterdiploma.dto.SubjectDTO;
import br.com.meli.obterdiploma.entity.Student;
import br.com.meli.obterdiploma.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/analyzeNotes")
    public ResponseEntity<StudentDTO> addAluno(
            @RequestBody @Valid StudentDTO studentDTO,
            UriComponentsBuilder uriBuilder) {
        Long id = studentService.addAluno(studentDTO);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getAluno(@PathVariable Long id){
        Student student = studentService.getAluno(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping("/diploma/{id}")
    public ResponseEntity<SubjectDTO> getResultado(@PathVariable Long id){
        SubjectDTO resultado =  studentService.getResultado(id);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
