package br.com.meli.crudProdutos.service;

import br.com.meli.crudProdutos.model.Produto;
import br.com.meli.crudProdutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAll() {
        return produtoRepository.getListaDeProdutos();
    }

    public Produto getProduto(int id) {
        return produtoRepository.getProduto(id);
    }

    public void deleteProduto(int id) {
        produtoRepository.deleteProduto(id);
    }

    public void cadastrarProduto(Produto produto) {
        produtoRepository.cadastrarProduto(produto);
    }

    public void alterarProduto(int id, Produto produto) {
        produtoRepository.alterarProduto(id, produto);
    }
}
