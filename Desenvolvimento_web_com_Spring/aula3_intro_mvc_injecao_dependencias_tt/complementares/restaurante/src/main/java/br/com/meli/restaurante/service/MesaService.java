package br.com.meli.restaurante.service;

import br.com.meli.restaurante.dao.PedidoDAO;
import br.com.meli.restaurante.dto.MesaDTO;
import br.com.meli.restaurante.entity.Mesa;
import br.com.meli.restaurante.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MesaService {

    private final PedidoDAO pedidoDAO;

    @Autowired
    public MesaService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public Mesa getMesa(Long id) {
        return pedidoDAO.getMesa(id);
    }

    public MesaDTO getPedidosDaMesa(Mesa mesa) {
        List<Pedido> listaDePedidosDaMesa = pedidoDAO.getPedidos(mesa);
        return new MesaDTO(listaDePedidosDaMesa);
    }

    public void closePedido(Mesa mesa) throws IOException {
        pedidoDAO.closePedido(mesa);
    }

}
