package br.com.meli.restaurante.service;

import br.com.meli.restaurante.dao.MesaDAO;
import br.com.meli.restaurante.dao.PedidoDAO;
import br.com.meli.restaurante.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MesaService {

    private final MesaDAO mesaDAO;
    private final PedidoDAO pedidoDAO;

    @Autowired
    public MesaService(MesaDAO mesaDAO, PedidoDAO pedidoDAO) {
        this.mesaDAO = mesaDAO;
        this.pedidoDAO = pedidoDAO;
    }

    public Mesa getMesa(Long id) {
        Optional<Mesa> optionalMesa = mesaDAO.getMesa(id);
        if (optionalMesa.isEmpty()){
            throw new IllegalStateException("Mesa não encontrada.");
        }
        return optionalMesa.get();
    }


    public void closePedido(Long id) {
        pedidoDAO.closePedido(id);
    }
}
