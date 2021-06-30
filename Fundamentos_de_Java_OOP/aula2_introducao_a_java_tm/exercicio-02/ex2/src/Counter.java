public class Counter {
    private int numero;

    public Counter(int numero) {
        this.numero = numero;
    }

    public Counter(Counter counter){
        this.numero = counter.getNumero();
    }

    public Counter() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void adicionaValorEmNumero(int valor){
        this.numero += valor;
    }
    public void subtraiValorDeNumero(int valor){
        this.numero -= valor;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "numero=" + numero +
                '}';
    }
}
