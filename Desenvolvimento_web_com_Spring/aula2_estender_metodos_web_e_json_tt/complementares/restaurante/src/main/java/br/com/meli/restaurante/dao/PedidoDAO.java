package br.com.meli.restaurante.dao;

import br.com.meli.restaurante.entity.Mesa;
import br.com.meli.restaurante.entity.Pedido;
import br.com.meli.restaurante.entity.Prato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoDAO {
    private static List<Pedido> listaDePedidos = new ArrayList<>();

    public PedidoDAO() {
        Bean();
    }

    public static List<Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public static void setListaDePedidos(List<Pedido> listaDePedidos) {
        PedidoDAO.listaDePedidos = listaDePedidos;
    }

    private static void Bean(){
        Pedido[] pedidos = {
                new Pedido(1L, new Mesa(), PratoDAO.getListaDePratos().toArray(new Prato[0]), 100.0),
                new Pedido(2L, new Mesa(), PratoDAO.getListaDePratos().toArray(new Prato[3]), 80.0),
                new Pedido(3L, new Mesa(), PratoDAO.getListaDePratos().toArray(new Prato[2]), 90.0)
        };

        Collections.addAll(listaDePedidos, pedidos);
    }



}
