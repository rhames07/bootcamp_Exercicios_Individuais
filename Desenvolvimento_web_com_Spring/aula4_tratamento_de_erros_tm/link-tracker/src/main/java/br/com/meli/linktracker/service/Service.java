package br.com.meli.linktracker.service;

import br.com.meli.linktracker.dto.LinkDto;
import br.com.meli.linktracker.dto.LinkMetricsDto;
import br.com.meli.linktracker.entity.Link;
import br.com.meli.linktracker.exception.BadRequestException;
import br.com.meli.linktracker.exception.NotFoundException;
import br.com.meli.linktracker.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public Long addLink(LinkDto linkDto) {
        Link link = LinkDto.converte(linkDto);
        repository.addLink(link);
        return link.getId();
    }

    public String redirectTo(Long linkId, String senha) {
        Optional<Link> link = Repository.listaDeLinks.stream()
                .filter(l -> l.getId().equals(linkId))
                .findFirst();
        if (link.isEmpty()){
            throw new NotFoundException("Link não encontrado.");
        }
        if (!link.get().isValido()){
            throw new BadRequestException("Link não é válido.");
        }
        if (!link.get().getSenha().equals(senha)){
            throw new BadRequestException("Senha incorreta.");
        }
        link.get().setAcionamento(link.get().getAcionamento()+1);
        return link.get().getUrlDestino();
    }

    public LinkMetricsDto getMetrics(Long linkId) {
        Optional<Link> link = Repository.listaDeLinks.stream()
                .filter(l -> l.getId().equals(linkId))
                .findFirst();
        if (link.isEmpty()){
            throw new NotFoundException("Link não encontrado.");
        }
        return new LinkMetricsDto(
                link.get().getUrlDestino(),
                link.get().getAcionamento(),
                link.get().isValido()
        );
    }

    public LinkMetricsDto invalidLink(Long linkId) {
        Optional<Link> link = Repository.listaDeLinks.stream()
                .filter(l -> l.getId().equals(linkId))
                .findFirst();
        if (link.isEmpty()){
            throw new NotFoundException("Link não encontrado.");
        }
        link.get().setValido(false);
        return new LinkMetricsDto(
                link.get().getUrlDestino(),
                link.get().getAcionamento(),
                link.get().isValido()
        );
    }
}
