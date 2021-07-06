package br.com.meli.clienteloja.entity;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private Long id;
    private List<Produto> produtos;
    private double valor;
    private LocalDate data;

    public Pedido() {
    }

    public Pedido(Long id, List<Produto> produtos) {
        this.id = id;
        this.produtos = produtos;
        this.valor = valorDaCompra(produtos);
        this.data = LocalDate.now();
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    private double valorDaCompra(List<Produto> produtos) {
        double valor = 0;
        for (Produto p: produtos) {
            valor += (p.getPreco() * p.getQuantidade());
        }
        return valor;
    }
}
