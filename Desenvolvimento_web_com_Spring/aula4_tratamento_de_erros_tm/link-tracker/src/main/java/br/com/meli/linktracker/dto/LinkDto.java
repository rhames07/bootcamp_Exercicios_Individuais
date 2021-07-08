package br.com.meli.linktracker.dto;

import br.com.meli.linktracker.entity.Link;
import br.com.meli.linktracker.repository.Repository;

public class LinkDto {
    private String urlDestino;
    private String senha;

    public LinkDto(String urlDestino, String senha) {
        this.urlDestino = urlDestino;
        this.senha = senha;
    }

    public LinkDto() {
    }

    public String getUrlDestino() {
        return urlDestino;
    }

    public void setUrlDestino(String urlDestino) {
        this.urlDestino = urlDestino;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static Link converte(LinkDto linkDto){
        return new Link(
                (long) Repository.listaDeLinks.size()+1,
                linkDto.getUrlDestino(),
                linkDto.getSenha()
        );
    }

}
