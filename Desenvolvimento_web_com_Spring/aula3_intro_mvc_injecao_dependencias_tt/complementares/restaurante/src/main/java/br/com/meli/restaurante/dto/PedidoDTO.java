package br.com.meli.restaurante.dto;

import br.com.meli.restaurante.entity.Mesa;
import br.com.meli.restaurante.entity.Prato;

import java.util.List;

public class PedidoDTO {
    private Mesa mesa;
    private List<Prato> pratos;

    public PedidoDTO() {
    }

    public PedidoDTO(Mesa mesa, List<Prato> pratos) {
        this.mesa = mesa;
        this.pratos = pratos;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }


    public double valorPratos(List<Prato> pratos){
        double total = 0;
        for (Prato p: pratos){
            total += p.getPreco() * p.getQuantidade();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "mesa=" + mesa +
                ", pratos=" + pratos +
                '}';
    }
}
