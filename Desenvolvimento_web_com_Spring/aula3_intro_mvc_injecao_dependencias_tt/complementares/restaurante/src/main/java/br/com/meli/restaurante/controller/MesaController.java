package br.com.meli.restaurante.controller;

import br.com.meli.restaurante.dto.MesaDTO;
import br.com.meli.restaurante.entity.Caixa;
import br.com.meli.restaurante.entity.Mesa;
import br.com.meli.restaurante.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    private final MesaService mesaService;

    @Autowired
    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDTO> getMesa(@PathVariable Long id){
        Mesa mesa = mesaService.getMesa(id);
        MesaDTO mesaDTO = mesaService.getPedidosDaMesa(mesa);
        return new ResponseEntity<>(mesaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/fechar/{id}")
    public ResponseEntity<Double> closePedido(@PathVariable Long id){
        Mesa mesa = mesaService.getMesa(id);
        MesaDTO mesaDTO = mesaService.getPedidosDaMesa(mesa);
        try{
            Caixa.setValorEmCaixa(mesaDTO.getPedido().get(0).getValor());
            mesaService.closePedido(mesa);
        } catch (Exception e){
            throw new IllegalStateException("Mesa sem pedidos.");
        }
        return new ResponseEntity<>(Caixa.getValorEmCaixa(), HttpStatus.OK);
    }
}
