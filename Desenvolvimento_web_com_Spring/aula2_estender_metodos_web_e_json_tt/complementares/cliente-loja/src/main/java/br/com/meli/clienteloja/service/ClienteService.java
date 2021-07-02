package br.com.meli.clienteloja.service;

import br.com.meli.clienteloja.dao.ClienteDao;
import br.com.meli.clienteloja.dto.ClienteDto;
import br.com.meli.clienteloja.entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteDao clienteDao;

    public ClienteService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public ClienteDto getCliente(Long id) {
        Cliente cliente =  clienteDao.getCliente(id);
        return ClienteDto.converte(cliente);
    }
}
