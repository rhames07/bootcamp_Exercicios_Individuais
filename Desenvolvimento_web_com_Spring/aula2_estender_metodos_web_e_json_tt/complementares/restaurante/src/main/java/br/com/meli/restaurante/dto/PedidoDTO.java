package br.com.meli.restaurante.dto;

import br.com.meli.restaurante.entity.Mesa;
import br.com.meli.restaurante.entity.Prato;

public class PedidoDTO {
    private Mesa mesa;
    private Prato[] prato;
    private Double valor;

    public PedidoDTO() {
    }

    public PedidoDTO(Mesa mesa, Prato[] prato, Double valor) {
        this.mesa = mesa;
        this.prato = prato;
        this.valor = valor;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesaDTO) {
        this.mesa = mesaDTO;
    }

    public Prato[] getPratos() {
        return prato;
    }

    public void setPratos(Prato[] prato) {
        this.prato = prato;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
