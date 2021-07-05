package br.com.meli.restaurante.entity;

public class Mesa {
    private Long id;

    public Mesa() {
    }

    public Mesa(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorPedido(Pedido pedido){
        return pedido.getValor();
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                '}';
    }
}
