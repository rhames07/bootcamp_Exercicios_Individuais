package br.com.meli.linktracker.entity;

public class Link {
    private Long id;
    private String urlDestino;
    private int acionamento;
    private boolean valido;
    private String senha;

    public Link(Long id, String urlDestino, String senha) {
        this.id = id;
        this.urlDestino = urlDestino;
        this.acionamento = 0;
        this.valido = true;
        this.senha = senha;
    }

    public Link() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlDestino() {
        return urlDestino;
    }

    public void setUrlDestino(String urlDestino) {
        this.urlDestino = urlDestino;
    }

    public int getAcionamento() {
        return acionamento;
    }

    public void setAcionamento(int acionamento) {
        this.acionamento = acionamento;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
