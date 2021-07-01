package br.com.meli.obterdiploma.dto;

import br.com.meli.obterdiploma.dao.AlunoDAO;
import br.com.meli.obterdiploma.entity.Aluno;
import br.com.meli.obterdiploma.entity.Disciplina;

public class AlunoDTO {
    private String nome;
    private Disciplina[] disciplinas;

    public AlunoDTO(String nome, Disciplina[] disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public static Aluno converte(AlunoDTO alunoDTO) {
        Long id = (long) AlunoDAO.getListaDeAlunos().size()+1;
        return new Aluno(id, alunoDTO.getNome(), alunoDTO.getDisciplinas());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }
}
