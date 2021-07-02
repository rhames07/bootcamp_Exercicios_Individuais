package br.com.meli.restaurante.dao;

import br.com.meli.restaurante.entity.Prato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PratoDAO {
    private static List<Prato> listaDePratos = new ArrayList<>();

    public PratoDAO() {
        Bean();
    }

    public static List<Prato> getListaDePratos() {
        return listaDePratos;
    }

    public static void setListaDePratos(List<Prato> listaDePratos) {
        PratoDAO.listaDePratos = listaDePratos;
    }

    private static void Bean(){
        Prato[] pratos = {
                new Prato(1L,80.0, "prato 1", 1.0),
                new Prato(2L,100.0, "prato 2", 1.0),
                new Prato(3L,80.0, "prato 3", 1.0),
                new Prato(4L,90.0, "prato 4", 1.0),
                new Prato(5L,75.0, "prato 5", 1.0),
                new Prato(6L,125.0, "prato 6", 1.0)
            };

        Collections.addAll(listaDePratos, pratos);
        }
    }

