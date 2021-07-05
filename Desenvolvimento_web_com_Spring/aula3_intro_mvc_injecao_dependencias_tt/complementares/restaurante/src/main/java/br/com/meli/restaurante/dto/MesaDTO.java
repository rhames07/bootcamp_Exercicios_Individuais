package br.com.meli.restaurante.dto;

import br.com.meli.restaurante.entity.Pedido;

import java.util.List;

public class MesaDTO {
    private List<Pedido> pedido;

    public MesaDTO() {
    }

    public MesaDTO(List<Pedido> pedidos) {
        this.pedido = pedidos;
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
