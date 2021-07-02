package br.com.meli.restaurante.entity;

public class Prato {
    private Long id;
    private Double preco;
    private String descricao;
    private Double quantidade;

    public Prato() {
    }

    public Prato(Long id, Double preco, String descricao, Double quantidade) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Prato{" +
                "id=" + id +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
