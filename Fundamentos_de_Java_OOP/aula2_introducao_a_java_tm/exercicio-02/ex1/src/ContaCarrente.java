public class ContaCarrente {
    private String nomeCliente;
    private String agencia;
    private String conta;
    private double saldo;

    public ContaCarrente(String nomeCliente, String agencia, String conta, double saldo) {
        this.nomeCliente = nomeCliente;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
    }

    public ContaCarrente(ContaCarrente conta){
        this.nomeCliente = conta.getNomeCliente();
        this.conta = conta.getConta();
        this.agencia = conta.getAgencia();
        this.saldo = conta.getSaldo();
    }

    public ContaCarrente() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCarrente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public void deposito(double valor){
        this.saldo += valor;
    }

    public void saque(double valor){
        this.saldo -= valor;
    }

    public void transferencia(ContaCarrente conta, double valor){
        this.saldo -= valor;
        conta.setSaldo(conta.getSaldo() + valor);
    }

    public void devolucao(ContaCarrente conta, double valor){
        this.saldo -= valor;
        conta.setSaldo(conta.getSaldo() + valor);
    }
}
