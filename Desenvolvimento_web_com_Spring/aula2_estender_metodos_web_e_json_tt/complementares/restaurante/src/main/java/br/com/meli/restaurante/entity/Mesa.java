package br.com.meli.restaurante.entity;

public class Mesa {
    private Long id;
    private Pedido[] pedidos;
    private Double valorConsumido;

    public Mesa() {
    }

    public Mesa(Long id, Pedido[] pedidos, Double valorConsumido) {
        this.id = id;
        this.pedidos = pedidos;
        this.valorConsumido = valorConsumido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido[] getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido[] pedidos) {
        this.pedidos = pedidos;
    }

    public Double getValorConsumido() {
        return valorConsumido;
    }

    public void setValorConsumido(Double valorConsumido) {
        this.valorConsumido = valorConsumido;
    }
}
