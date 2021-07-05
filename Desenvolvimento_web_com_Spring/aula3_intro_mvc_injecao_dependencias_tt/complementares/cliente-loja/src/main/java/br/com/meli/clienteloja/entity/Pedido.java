package br.com.meli.clienteloja.entity;

import java.util.List;

public class Pedido {
    private Long id;
    private List<Produto> produtos;
    private double valor;

    public Pedido() {
    }

    public Pedido(Long id, List<Produto> produtos, double valor) {
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
