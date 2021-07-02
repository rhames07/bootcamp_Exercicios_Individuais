package br.com.meli.clienteloja.dao;

import br.com.meli.clienteloja.entity.Pedido;
import br.com.meli.clienteloja.entity.Produto;

public class PedidoDao {
    public static Pedido[] listadePedidos = {
        new Pedido(1L, ProdutoDao.listaDeProdutos1, calculaTotalPedido(ProdutoDao.listaDeProdutos1)),
        new Pedido(2L, ProdutoDao.listaDeProdutos2, calculaTotalPedido(ProdutoDao.listaDeProdutos2))
    };

    private static double calculaTotalPedido(Produto[] produtos){
        double valorTotal = 0;
        for (Produto p: produtos) {
            valorTotal+=(p.getPreco() * p.getQuantidade());
        }
        return valorTotal;
    }
}
