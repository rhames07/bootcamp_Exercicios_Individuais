package br.com.meli.clienteloja.controller;

import br.com.meli.clienteloja.dto.ClienteDto;
import br.com.meli.clienteloja.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getCliente(@PathVariable Long id){
        ClienteDto cliente = clienteService.getCliente(id);
        return new ResponseEntity<ClienteDto>(cliente, HttpStatus.OK);
    }
}
