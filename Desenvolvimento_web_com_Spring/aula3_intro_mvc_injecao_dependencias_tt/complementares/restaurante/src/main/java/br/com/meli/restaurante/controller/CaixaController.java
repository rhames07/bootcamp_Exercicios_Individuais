package br.com.meli.restaurante.controller;

import br.com.meli.restaurante.entity.Pedido;
import br.com.meli.restaurante.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

    private final CaixaService caixaService;

    @Autowired
    public CaixaController(CaixaService caixaService){
        this.caixaService = caixaService;
    }

    @GetMapping("/pedidos/abertos")
    public ResponseEntity<List<Pedido>> getPedidosHoje(){
        List<Pedido> listaDePedidosAbertos = caixaService.getPedidosHoje();
        return new ResponseEntity<>(listaDePedidosAbertos, HttpStatus.OK);
    }
}
