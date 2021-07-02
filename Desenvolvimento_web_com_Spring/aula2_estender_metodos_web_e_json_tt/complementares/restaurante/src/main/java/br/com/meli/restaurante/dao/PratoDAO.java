package br.com.meli.restaurante.dao;

import br.com.meli.restaurante.entity.Prato;

import java.util.ArrayList;
import java.util.List;

public class PratoDAO {
    private static List<Prato> listaDePratos = new ArrayList<>(List.of(
            new Prato(1L,80.0, "prato 1", 1.0),
            new Prato(2L,100.0, "prato 2", 2.0)
    ));

    public static List<Prato> getListaDePratos() {
        return listaDePratos;
    }
}

