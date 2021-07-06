package br.com.meli.clienteloja.dto;

import br.com.meli.clienteloja.entity.Produto;

import java.util.List;

public class PedidoDto {
    private List<Produto> produtos;
    private double valor;

    public PedidoDto() {
    }

    public PedidoDto(List<Produto> produtos) {
        this.produtos = produtos;
        this.valor = valorDaCompra(produtos);
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

    public double valorDaCompra(List<Produto> produtos) {
        double valor = 0;
        for (Produto p: produtos) {
            valor += (p.getPreco() * p.getQuantidade());
        }
        return valor;
    }

    @Override
    public String toString() {
        return "PedidoDto{" +
                "produtos=" + produtos +
                '}';
    }
}
