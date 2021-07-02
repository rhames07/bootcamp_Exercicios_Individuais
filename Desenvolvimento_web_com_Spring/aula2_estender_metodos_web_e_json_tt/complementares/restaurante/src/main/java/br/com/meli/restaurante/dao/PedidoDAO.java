package br.com.meli.restaurante.dao;

import br.com.meli.restaurante.entity.Pedido;
import br.com.meli.restaurante.entity.Prato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PedidoDAO {
    private static List<Pedido> listaDePedidos = new ArrayList<>(List.of(
            new Pedido(1L, MesaDAO.getListaDeMesas().get(0), PratoDAO.getListaDePratos()),
            new Pedido(2L, MesaDAO.getListaDeMesas().get(1), new ArrayList<>(List.of(PratoDAO.getListaDePratos().get(0))))
    ));

    public static List<Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public static List<Pedido> getPedidos(Long id) {
        return listaDePedidos.stream().filter(p -> p.getMesa().getId().equals(id)).collect(Collectors.toList());
    }


    public void closePedido(Long id) {
            listaDePedidos.removeIf(p -> p.getMesa().getId().equals(id));

    }
}
