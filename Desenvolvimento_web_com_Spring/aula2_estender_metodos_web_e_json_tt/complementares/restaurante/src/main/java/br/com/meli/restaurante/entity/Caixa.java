package br.com.meli.restaurante.entity;

public class Caixa {
    private static double valorEmCaixa = 0.0;

    public Caixa() {
    }

    public static double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public static void setValorEmCaixa(double valorEmCaixa) {
        Caixa.valorEmCaixa += valorEmCaixa;
    }

    @Override
    public String toString() {
        return "Caixa{ valorEmCaixa: " + valorEmCaixa +"}";
    }
}
