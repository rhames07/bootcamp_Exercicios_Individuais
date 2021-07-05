package br.com.meli.restaurante.dao;

import br.com.meli.restaurante.dto.PedidoDTO;
import br.com.meli.restaurante.entity.Mesa;
import br.com.meli.restaurante.entity.Pedido;
import br.com.meli.restaurante.entity.StatusPedidos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PedidoDAO {

    private List<Pedido> listaDePedidos;

    private static final File FILE = new File("pedidos.json");

    private final ObjectMapper mapper;

    @Autowired
    public PedidoDAO(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    private void loadData() throws IOException {
        FileInputStream inputStream = new FileInputStream(FILE);
        TypeReference<List<Pedido>> typeReference = new TypeReference<>(){};
        this.listaDePedidos = mapper.readValue(inputStream, typeReference);
        inputStream.close();
    }

    public List<Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public void addPedido(Pedido pedido) throws IOException {
        listaDePedidos.add(pedido);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(FILE, listaDePedidos);
    }

    public Mesa getMesa(Long id) {
        Optional<Pedido> pedido =  listaDePedidos.stream()
                .filter(p -> p.getMesa().getId().equals(id))
                .findFirst();
        if (pedido.isEmpty()){
            throw new IllegalStateException("Mesa sem pedidos cadastrados.");
        }
        return pedido.get().getMesa();
    }

    public List<Pedido> getPedidos(Mesa mesa) {
        return listaDePedidos.stream()
                .filter(p -> p.getMesa().getId().equals(mesa.getId()))
                .collect(Collectors.toList());
    }

    public void closePedido(Mesa mesa) throws IOException {
        List<Pedido> listaDePedidosNaMesa = this.getPedidos(mesa);
        for (Pedido p: listaDePedidosNaMesa) {
            listaDePedidos.remove(p);
        }
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(FILE, listaDePedidos);
    }

    public void deletePedido(Long pedidoId) throws IOException {
        Optional<Pedido> pedidoOptional = listaDePedidos.stream().filter(p -> p.getId().equals(pedidoId)).findFirst();
        if (pedidoOptional.isEmpty()){
            throw new IllegalStateException("Pedido não encontrado.");
        }
        listaDePedidos.remove(pedidoOptional.get());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(FILE, listaDePedidos);
    }

    public Pedido alteraPedido(Long pedidoId, PedidoDTO pedidoDto) throws IOException {
        Optional<Pedido> pedidoOptional = listaDePedidos.stream().filter(p -> p.getId().equals(pedidoId)).findFirst();

        if (pedidoOptional.isEmpty()) {
            throw new IllegalStateException("Pedido não encontrado.");
        }
        pedidoOptional.get().setMesa(pedidoDto.getMesa());
        pedidoOptional.get().setPratos(pedidoDto.getPratos());
        pedidoOptional.get().setValor(pedidoDto.valorPratos(pedidoDto.getPratos()));

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(FILE, listaDePedidos);
        return pedidoOptional.get();
    }

    public Pedido fecharPedido(Long pedidoId) throws IOException {
        Optional<Pedido> pedidoOptional = listaDePedidos.stream().filter(p -> p.getId().equals(pedidoId)).findFirst();
        if (pedidoOptional.isEmpty()) {
            throw new IllegalStateException("Pedido não encontrado.");
        }
        pedidoOptional.get().setStatusPedidos(StatusPedidos.FECHADO);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(FILE, listaDePedidos);
        return pedidoOptional.get();
    }

    public List<Pedido> pedidosAbertos() {
        return listaDePedidos.stream()
                .filter(p -> p.getStatusPedidos().equals(StatusPedidos.ABERTO))
                .collect(Collectors.toList());
    }

    public List<Pedido> pedidosFechados() {
        return listaDePedidos.stream()
                .filter(p -> p.getStatusPedidos().equals(StatusPedidos.FECHADO))
                .collect(Collectors.toList());
    }
}
