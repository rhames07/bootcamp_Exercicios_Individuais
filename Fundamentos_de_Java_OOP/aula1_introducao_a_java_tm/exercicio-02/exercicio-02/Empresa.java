import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empresa{
    String nome;
    LocalDate data;
    Double valor;

    public Empresa(String nome,LocalDate data,Double valor){
        this.nome = nome;
        this.data = data;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public double valorizacao(double valor, double porcentagem){
        return valor + (valor * porcentagem);
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

    @Override
    public String toString() {
        return "Empresa " + nome + " - " + data.format(formatter) + " - Valor da empresa: " + String.format("%,.2f", valor) + "m";
    }
}