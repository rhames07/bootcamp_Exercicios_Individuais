package br.com.meli.clienteloja.dao;

import br.com.meli.clienteloja.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;

@Repository
public class ClienteDao {
    public static Cliente[] listaDeClientes = {
            new Cliente(1L, "Felipe", "32156487951", "felipe@mail.com", "11954823651", PedidoDao.listadePedidos)
    };

    public Cliente getCliente(Long id) {
        Optional<Cliente> dtoOptional =  Arrays.stream(listaDeClientes).filter(c -> c.getId() == id).findFirst();
        if(dtoOptional.isEmpty()){
            throw new IllegalStateException("Cliente não encontrado.");
        }
        return dtoOptional.get();
    }
}
