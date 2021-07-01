package br.com.meli.obterdiploma.dto;

import br.com.meli.obterdiploma.entity.Aluno;

public class DiplomaDTO {
    private Aluno aluno;
    private double media;
    private String mensagem;

    public DiplomaDTO(Aluno aluno, double media, String mensagem) {
        this.aluno = aluno;
        this.media = media;
        this.mensagem = mensagem;
    }

    public DiplomaDTO() {
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
