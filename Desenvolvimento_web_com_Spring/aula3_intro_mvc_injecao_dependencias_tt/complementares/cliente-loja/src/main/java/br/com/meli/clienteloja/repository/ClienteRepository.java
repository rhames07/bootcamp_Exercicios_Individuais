package br.com.meli.clienteloja.repository;

import br.com.meli.clienteloja.dto.PedidoDto;
import br.com.meli.clienteloja.entity.Cliente;
import br.com.meli.clienteloja.entity.Pedido;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private static final File FILE = new File("pedidos.json");

    private final ObjectMapper mapper;
    private List<Cliente> listaDeClientes;

    @Autowired
    public ClienteRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    @Autowired
    private void loadData() throws IOException {
        FileInputStream inputStream = new FileInputStream(FILE);
        TypeReference<List<Cliente>> typeReference = new TypeReference<>(){};
        this.listaDeClientes = mapper.readValue(inputStream, typeReference);
        inputStream.close();
    }

    public void addCliente(Cliente cliente) throws IOException {
        listaDeClientes.add(cliente);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(FILE, listaDeClientes);
    }


    public void addPedido(Cliente cliente, Pedido pedido) throws IOException {
        List<Pedido> pedidosDoCliente = cliente.getPedidos();
        pedidosDoCliente.add(pedido);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(FILE, listaDeClientes);
    }

    public Cliente updatePedido(Cliente cliente, long idPedido, PedidoDto pedidoDto) throws IOException {
        for (Pedido p: cliente.getPedidos()){
            if(p.getId().equals(idPedido)){
                p.setProdutos(pedidoDto.getProdutos());
                p.setValor(pedidoDto.getValor());
                break;
            }
        }
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(FILE, listaDeClientes);
        return cliente;

    }

    public void deletePedido(Cliente cliente, Pedido pedido) throws IOException {
        List<Pedido> pedidos = new ArrayList<>();
        for (Pedido p : cliente.getPedidos()){
            if (!p.getId().equals(pedido.getId())){
                pedidos.add(p);
            }
        }
        cliente.setPedidos(pedidos);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(FILE, listaDeClientes);
    }
}
