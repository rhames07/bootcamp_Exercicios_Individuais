package br.com.meli.restaurante.dao;

import br.com.meli.restaurante.entity.Mesa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MesaDAO {
    private static List<Mesa> listaDeMesas =new ArrayList<>(List.of(
            new Mesa(1L),
            new Mesa(2L)
    ));

    public static List<Mesa> getListaDeMesas() {
        return listaDeMesas;
    }

    public Optional<Mesa> getMesa(Long id) {
        return listaDeMesas.stream().filter(m -> m.getId().equals(id)).findFirst();
    }
}
