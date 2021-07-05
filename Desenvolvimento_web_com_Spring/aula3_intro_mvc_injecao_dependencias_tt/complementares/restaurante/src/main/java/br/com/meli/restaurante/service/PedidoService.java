package br.com.meli.restaurante.service;

import br.com.meli.restaurante.dao.PedidoDAO;
import br.com.meli.restaurante.dto.PedidoDTO;
import br.com.meli.restaurante.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoDAO pedidoDAO;

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public List<Pedido> getAllPedidos(){
        return pedidoDAO.getListaDePedidos();
    }

    public Pedido getPedido(Long pedidoId) {
        List<Pedido> listDePedidos = pedidoDAO.getListaDePedidos();
        Optional<Pedido> pedido = listDePedidos.stream()
                .filter(p -> p.getId().equals(pedidoId))
                .findFirst();
        if(pedido.isEmpty()){
            throw new IllegalStateException("Pedido não encontrado.");
        }
        return pedido.get();
    }

    public Long addPedido(PedidoDTO pedidoDto) throws IOException {
        List<Pedido> listaDePedidos = pedidoDAO.getListaDePedidos();
        Long id = (long) listaDePedidos.size()+1;
        Pedido pedido = new Pedido(id, pedidoDto.getMesa(), pedidoDto.getPratos());
        pedidoDAO.addPedido(pedido);
        return id;
    }

    public void deletePedido(Long pedidoId) throws IOException {
        pedidoDAO.deletePedido(pedidoId);
    }


    public Pedido alteraPedido(Long pedidoId, PedidoDTO pedidoDto) throws IOException {
        return pedidoDAO.alteraPedido(pedidoId, pedidoDto);
    }

    public Pedido fecharPedido(Long pedidoId) throws IOException {
        return pedidoDAO.fecharPedido(pedidoId);
    }

    public List<Pedido> pedidosAbertos() {
        return pedidoDAO.pedidosAbertos();
    }

    public List<Pedido> pedidosFechados() {
        return pedidoDAO.pedidosFechados();
    }
}
