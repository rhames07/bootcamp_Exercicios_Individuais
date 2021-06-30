package br.com.meli.crudProdutos.repository;

import br.com.meli.crudProdutos.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProdutoRepository {

    private static int generateId = 1;

    List<Produto> listaDeProdutos = new ArrayList<>();

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public Produto getProduto(int id){
        for (Produto p: listaDeProdutos) {
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Produto não encontrado.");
    }

    public void deleteProduto(int id){
        listaDeProdutos.removeIf(p -> p.getId() == id);
    }

    public void cadastrarProduto(Produto produto){
        try{
            produto.setId(generateId);
            listaDeProdutos.add(produto);
            generateId++;
        } catch (Exception e){
            throw new RuntimeException("Falha ao cadastrar produto.");
        }
    }

    public void alterarProduto(int id, Produto produto){
        for (Produto p: listaDeProdutos) {
            if (p.getId() == id){
                p.setMarca(produto.getMarca());
                p.setNome(produto.getNome());
                p.setPreco(produto.getPreco());
            } else {
                throw new RuntimeException("Erro ao alterar produto.");
            }
        }
    }
}
