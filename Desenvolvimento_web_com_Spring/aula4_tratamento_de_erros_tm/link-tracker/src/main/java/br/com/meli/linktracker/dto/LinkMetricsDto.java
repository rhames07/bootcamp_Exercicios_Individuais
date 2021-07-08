package br.com.meli.linktracker.dto;

public class LinkMetricsDto {
    private String urlDestino;
    private int acionamento;
    private boolean valido;

    public LinkMetricsDto() {
    }

    public LinkMetricsDto(String urlDestino, int acionamento, boolean valido) {
        this.urlDestino = urlDestino;
        this.acionamento = acionamento;
        this.valido = valido;
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
}
