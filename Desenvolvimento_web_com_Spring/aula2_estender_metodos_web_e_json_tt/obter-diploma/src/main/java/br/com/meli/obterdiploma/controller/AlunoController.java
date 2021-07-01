package br.com.meli.obterdiploma.controller;

import br.com.meli.obterdiploma.dto.AlunoDTO;
import br.com.meli.obterdiploma.dto.DiplomaDTO;
import br.com.meli.obterdiploma.entity.Aluno;
import br.com.meli.obterdiploma.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> addAluno(@RequestBody AlunoDTO alunoDTO, UriComponentsBuilder uriBuilder){
        Long id = alunoService.addAluno(alunoDTO);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Long id){
        Aluno aluno = alunoService.getAluno(id);
        return new ResponseEntity<>(aluno,HttpStatus.OK);
    }

    @GetMapping("/diploma/{id}")
    public ResponseEntity<DiplomaDTO> getResultado(@PathVariable Long id){
        DiplomaDTO resultado =  alunoService.getResultado(id);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
