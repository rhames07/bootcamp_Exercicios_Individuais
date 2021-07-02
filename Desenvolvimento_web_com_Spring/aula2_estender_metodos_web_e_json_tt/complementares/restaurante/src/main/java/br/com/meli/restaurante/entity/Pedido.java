package br.com.meli.restaurante.entity;

public class Pedido {
    private Long id;
    private Mesa mesa;
    private Prato[] pratos;
    private Double valor;

    public Pedido() {
    }

    public Pedido(Long id, Mesa mesa, Prato[] pratos, Double valor) {
        this.id = id;
        this.mesa = mesa;
        this.pratos = pratos;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Prato[] getPratos() {
        return pratos;
    }

    public void setPratos(Prato[] pratos) {
        this.pratos = pratos;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
