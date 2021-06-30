package br.com.meli.crudProdutos.controller;

import br.com.meli.crudProdutos.model.Produto;
import br.com.meli.crudProdutos.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/all")
    public List<Produto> produtoList(){
        return produtoService.getAll();
    }

    @GetMapping("/{produtoId}")
    public Produto getProduto(@PathVariable("produtoId") int id){
        return produtoService.getProduto(id);
    }

    @DeleteMapping("/{produtoId}")
    public void deleteProduto(@PathVariable("produtoId") int id){
        produtoService.deleteProduto(id);
    }
    @PostMapping
    public void cadastrarProduto(@RequestBody Produto produto){
        produtoService.cadastrarProduto(produto);
    }

    @PutMapping("/{produtoId}")
    public void alterarProduto(
            @PathVariable("produtoId") int id,
            @RequestBody Produto produto){
        produtoService.alterarProduto(id, produto);
    }
}
