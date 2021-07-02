package br.com.meli.restaurante.dto;

import br.com.meli.restaurante.entity.Pedido;

public class MesaDTO {
    private Pedido[] pedido;
    private Double valorConsumido;

    public MesaDTO() {
    }

    public MesaDTO(Pedido[] pedidos, Double valorConsumido) {
        this.pedido = pedidos;
        this.valorConsumido = valorConsumido;
    }

    public Pedido[] getPedidos() {
        return pedido;
    }

    public void setPedidos(Pedido[] pedido) {
        this.pedido = pedido;
    }

    public Double getValorConsumido() {
        return valorConsumido;
    }

    public void setValorConsumido(Double valorConsumido) {
        this.valorConsumido = valorConsumido;
    }
}
