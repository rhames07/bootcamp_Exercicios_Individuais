package br.com.meli.clienteloja.dto;

import br.com.meli.clienteloja.entity.Cliente;
import br.com.meli.clienteloja.entity.Pedido;

public class ClienteDto {
    private String nome, cpf, email, telefone;
    private Pedido[] pedidos;

    public ClienteDto() {
    }

    public ClienteDto(String nome, String cpf, String email, String telefone, Pedido[] pedidos) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pedido[] getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido[] pedidos) {
        this.pedidos = pedidos;
    }

    public static ClienteDto converte(Cliente cliente){
        return new ClienteDto(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getPedidos());
    }
}
