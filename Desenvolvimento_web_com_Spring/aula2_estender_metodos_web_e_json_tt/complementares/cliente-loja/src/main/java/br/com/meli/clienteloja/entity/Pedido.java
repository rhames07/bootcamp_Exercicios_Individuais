package br.com.meli.clienteloja.entity;

public class Pedido {
    private Long id;
    private Produto[] produtos;
    private double valor;

    public Pedido() {
    }

    public Pedido(Long id, Produto[] produtos, double valor) {
        this.id = id;
        this.produtos = produtos;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
