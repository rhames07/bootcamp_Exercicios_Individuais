package br.com.meli.obterdiploma.service;

import br.com.meli.obterdiploma.dao.AlunoDAO;
import br.com.meli.obterdiploma.dto.AlunoDTO;
import br.com.meli.obterdiploma.dto.DiplomaDTO;
import br.com.meli.obterdiploma.entity.Aluno;
import br.com.meli.obterdiploma.entity.Disciplina;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoDAO alunoDAO;

    public AlunoService(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public Long addAluno(AlunoDTO alunoDTO) {
        Aluno aluno = AlunoDTO.converte(alunoDTO);
        return alunoDAO.addAluno(aluno);
    }

    public Aluno getAluno(Long id) {
        return alunoDAO.getAluno(id);
    }

    public DiplomaDTO getResultado(Long id) {
        Aluno aluno = alunoDAO.getAluno(id);
        List<Double> notas = new ArrayList<>();
        String mensagem;

        Disciplina[] disciplinas = aluno.getDisciplinas();
        Arrays.stream(disciplinas).forEach(a -> notas.add(a.getNota()));

        double mediaFinal = 0;
        for (Double nota: notas) {
            mediaFinal+=nota;
        }
        mediaFinal = mediaFinal/notas.size();

        if (mediaFinal > 9){
            mensagem = "Parabéns, você passou!";
        } else {
            mensagem = "Infelizmente você não passou.";
        }

        return new DiplomaDTO(aluno, mediaFinal, mensagem);
    }
}
