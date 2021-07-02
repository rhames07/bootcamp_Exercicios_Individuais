package br.com.meli.clienteloja.dao;

import br.com.meli.clienteloja.entity.Produto;

public class ProdutoDao {
    public static Produto[] listaDeProdutos1 = {
            new Produto(1L, "bolsa", "azul", 1, 340.0),
            new Produto(2L, "chuteira", "verde", 2, 500.0),
            new Produto(3L, "casaco", "azul", 5, 250.0),
            new Produto(4L, "camiseta", "preto", 1, 20.0),
    };

    public static Produto[] listaDeProdutos2 = {
            new Produto(5L, "bolsa", "azul", 1, 100.0),
            new Produto(6L, "casaco", "azul", 5, 250.0),
    };



}
