package br.com.meli.clienteloja.service;

import br.com.meli.clienteloja.dto.ClienteDto;
import br.com.meli.clienteloja.dto.PedidoDto;
import br.com.meli.clienteloja.entity.Cliente;
import br.com.meli.clienteloja.entity.Pedido;
import br.com.meli.clienteloja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Long addCliente(ClienteDto clienteDto) throws IOException {
        Cliente cliente = new Cliente(
                (long) clienteRepository.getListaDeClientes().size()+1,
                clienteDto.getNome(),
                clienteDto.getCpf(),
                clienteDto.getEmail(),
                clienteDto.getTelefone());
        clienteRepository.addCliente(cliente);
        return cliente.getId();
    }

    public Cliente getCliente(long id) {
        List<Cliente> listaDeClientes = clienteRepository.getListaDeClientes();
        Optional<Cliente> optionalCliente = listaDeClientes.stream().filter(c -> c.getId().equals(id)).findFirst();
        if (optionalCliente.isEmpty()){
            throw new IllegalStateException("Cliente não encontrado.");
        }
        return optionalCliente.get();
    }

    public Long addPedido(long idCliente, PedidoDto pedidoDto) throws IOException {
        Cliente cliente = this.getCliente(idCliente);
        Long idPedido;
        try {
            idPedido = (long) cliente.getPedidos().size()+1;
        } catch (Exception e){
            idPedido = 1L;
        }
        Pedido pedido = new Pedido(idPedido, pedidoDto.getProdutos(), pedidoDto.getValor());
        clienteRepository.addPedido(cliente, pedido);
        return idPedido;
    }

    public Pedido getPedido(long idCliente, long idPedido) {
        Cliente cliente = this.getCliente(idCliente);
        Optional<Pedido> optionalPedido = cliente.getPedidos().stream().filter(p -> p.getId().equals(idPedido)).findFirst();
        if (optionalPedido.isEmpty()){
            throw new IllegalStateException("Pedido não encontrado.");
        }

        return optionalPedido.get();
    }

    public Cliente updatePedido(long idCliente, long idPedido, PedidoDto pedidoDto) throws IOException {
        Cliente cliente = this.getCliente(idCliente);
        return clienteRepository.updatePedido(cliente, idPedido, pedidoDto);
    }

    public void deletePedido(long idCliente, long idPedido) throws IOException {
        Cliente cliente = this.getCliente(idCliente);
        Optional<Pedido> optionalPedido = cliente.getPedidos().stream()
                .filter(p -> p.getId().equals(idPedido))
                .findFirst();
        if(optionalPedido.isEmpty()){
            throw new IllegalStateException("Pedido não encontrado.");
        }
        clienteRepository.deletePedido(cliente, optionalPedido.get());
    }
}
