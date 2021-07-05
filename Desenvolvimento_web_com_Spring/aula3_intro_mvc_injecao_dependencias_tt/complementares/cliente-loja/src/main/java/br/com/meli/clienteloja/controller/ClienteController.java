package br.com.meli.clienteloja.controller;

import br.com.meli.clienteloja.dto.ClienteDto;
import br.com.meli.clienteloja.dto.PedidoDto;
import br.com.meli.clienteloja.entity.Cliente;
import br.com.meli.clienteloja.entity.Pedido;
import br.com.meli.clienteloja.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/add")
    public ResponseEntity<ClienteDto> addCliente(@RequestBody ClienteDto clienteDto, UriComponentsBuilder builder) throws IOException {
        Long id = clienteService.addCliente(clienteDto);
        URI uri = builder.path("/cliente/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable long id){
        Cliente cliente = clienteService.getCliente(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("/{idCliente}/pedido")
    public ResponseEntity<Cliente> addPedido(
            @PathVariable long idCliente,
            @RequestBody PedidoDto pedidoDto,
            UriComponentsBuilder builder) throws IOException {
        Long idPedido = clienteService.addPedido(idCliente, pedidoDto);
        URI uri = builder.path("cliente/{idCliente}/pedido/{idPedido}").buildAndExpand(idCliente, idPedido).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{idCliente}/pedido/{idPedido}")
    public  ResponseEntity<Pedido> getPedido(
            @PathVariable long idCliente,
            @PathVariable long idPedido
    ){
        Pedido pedido = clienteService.getPedido(idCliente, idPedido);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PutMapping("/{idCliente}/pedido/{idPedido}")
    public  ResponseEntity<Cliente> updatePedido(
            @PathVariable long idCliente,
            @PathVariable long idPedido,
            @RequestBody PedidoDto pedidoDto
    ) throws IOException {
        Cliente cliente = clienteService.updatePedido(idCliente, idPedido, pedidoDto);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/{idCliente}/pedido/{idPedido}")
    public  ResponseEntity<Long> deletePedido(
            @PathVariable long idCliente,
            @PathVariable long idPedido
    ) throws IOException {
        clienteService.deletePedido(idCliente, idPedido);
        return new ResponseEntity<>(idPedido, HttpStatus.OK);
    }
}
