package br.com.meli.restaurante.entity;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private Long id;
    private Mesa mesa;
    private List<Prato> pratos;
    private Double valor;
    private StatusPedidos statusPedidos;
    private LocalDate data;

    public Pedido() {
    }

    public Pedido(Long id, Mesa mesa, List<Prato> pratos) {
        this.id = id;
        this.mesa = mesa;
        this.pratos = pratos;
        this.valor = setValorPratos(pratos);
        this.statusPedidos = StatusPedidos.ABERTO;
        this.data = LocalDate.now();
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

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusPedidos getStatusPedidos() {
        return statusPedidos;
    }

    public void setStatusPedidos(StatusPedidos statusPedidos) {
        this.statusPedidos = statusPedidos;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double setValorPratos(List<Prato> pratos){
        double total = 0;
        for (Prato p: pratos){
            total += p.getPreco() * p.getQuantidade();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", mesa=" + mesa +
                ", pratos=" + pratos +
                ", valor=" + valor +
                '}';
    }
}
