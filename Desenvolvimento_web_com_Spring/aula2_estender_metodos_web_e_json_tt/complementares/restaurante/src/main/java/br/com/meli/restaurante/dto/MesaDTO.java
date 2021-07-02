package br.com.meli.restaurante.dto;

import br.com.meli.restaurante.dao.PedidoDAO;
import br.com.meli.restaurante.entity.Mesa;
import br.com.meli.restaurante.entity.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MesaDTO {
    private List<Pedido> pedido;

    public MesaDTO() {
    }

    public MesaDTO(List<Pedido> pedidos) {
        this.pedido = pedidos;
    }

    public static MesaDTO converte(Mesa mesa) {
        List<Pedido> pedidos = PedidoDAO.getPedidos(mesa.getId());
        return new MesaDTO(pedidos);
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "MesaDTO{" +
                "pedido=" + pedido +
                '}';
    }
}
