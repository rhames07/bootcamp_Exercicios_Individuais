package br.com.meli.restaurante.controller;

import br.com.meli.restaurante.dto.PedidoDTO;
import br.com.meli.restaurante.entity.Pedido;
import br.com.meli.restaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pedido>> getAllPedidos(){
        List<Pedido> listaDePedidos = pedidoService.getAllPedidos();
        return new ResponseEntity<>(listaDePedidos, HttpStatus.OK);
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<Pedido> getPedido(@PathVariable Long pedidoId){
        Pedido pedido = pedidoService.getPedido(pedidoId);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pedido> addPedido(@RequestBody PedidoDTO pedidoDto, UriComponentsBuilder uriComponentsBuilder) throws IOException {
        System.out.println(pedidoDto);
        Long id = pedidoService.addPedido(pedidoDto);
        URI uri = uriComponentsBuilder.path("/pedido/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<Long> deletePedido(@PathVariable Long pedidoId) throws IOException {
        pedidoService.deletePedido(pedidoId);
        return new ResponseEntity<>(pedidoId, HttpStatus.OK);
    }

    @PutMapping("/{pedidoId}")
    public ResponseEntity<Pedido> alteraPedido(@PathVariable Long pedidoId, @RequestBody PedidoDTO pedidoDto) throws IOException {
        Pedido pedido = pedidoService.alteraPedido(pedidoId, pedidoDto);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PatchMapping("/{pedidoId}")
    public ResponseEntity<Pedido> fecharPedido(@PathVariable Long pedidoId) throws IOException {
        Pedido pedido = pedidoService.fecharPedido(pedidoId);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @GetMapping("/abertos")
    public ResponseEntity<List<Pedido>> pedidosAbertos(){
        List<Pedido> listaDePedidosAbertos = pedidoService.pedidosAbertos();
        return new ResponseEntity<>(listaDePedidosAbertos, HttpStatus.OK);
    }

    @GetMapping("/fechados")
    public ResponseEntity<List<Pedido>> pedidosFechados(){
        List<Pedido> listaDePedidosFechados = pedidoService.pedidosFechados();
        return new ResponseEntity<>(listaDePedidosFechados, HttpStatus.OK);
    }
}
