package br.com.meli.restaurante.service;

import br.com.meli.restaurante.dao.PedidoDAO;
import br.com.meli.restaurante.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaixaService {

    private final PedidoDAO pedidoDAO;

    @Autowired
    public CaixaService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public List<Pedido> getPedidosHoje() {
        List<Pedido> listaDePedidos = pedidoDAO.getListaDePedidos();
        return listaDePedidos.stream()
                .filter(p -> p.getData().equals(LocalDate.now()))
                .collect(Collectors.toList());
    }
}
