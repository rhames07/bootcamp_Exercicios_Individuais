package br.com.meli.restaurante.dao;

import br.com.meli.restaurante.entity.Mesa;
import br.com.meli.restaurante.entity.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MesaDAO {
    private static List<Mesa> listaDeMesas = new ArrayList<>();

    public MesaDAO() {
        Bean();
    }

    private static void Bean(){
        Mesa[] mesas = {
                new Mesa(1L, PedidoDAO.getListaDePedidos().toArray(new Pedido[0]), 100.0),
                new Mesa(1L, PedidoDAO.getListaDePedidos().toArray(new Pedido[1]), 100.0),
                new Mesa(1L, PedidoDAO.getListaDePedidos().toArray(new Pedido[2]), 100.0),
                new Mesa(2L, PedidoDAO.getListaDePedidos().toArray(new Pedido[4]), 80.0),
                new Mesa(3L, PedidoDAO.getListaDePedidos().toArray(new Pedido[3]), 90.0),
        };

        Collections.addAll(listaDeMesas, mesas);
    }
}
