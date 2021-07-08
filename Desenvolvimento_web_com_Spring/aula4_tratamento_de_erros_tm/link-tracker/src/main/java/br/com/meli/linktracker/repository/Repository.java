package br.com.meli.linktracker.repository;

import br.com.meli.linktracker.entity.Link;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    public static List<Link> listaDeLinks = new ArrayList<>();

    public void addLink(Link link) {
        listaDeLinks.add(link);
    }
}
