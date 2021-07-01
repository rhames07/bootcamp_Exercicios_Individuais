package br.com.meli.obterdiploma.entity;

public class Aluno {

    private Long id;
    private String nome;
    private Disciplina[] disciplinas;

    public Aluno() {
    }

    public Aluno(Long id, String nome, Disciplina[] disciplinas) {
        this.id = id;
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
