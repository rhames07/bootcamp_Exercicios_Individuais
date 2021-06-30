public class Produto{
    Integer id;
    String nome;
    Double preco;
    Integer quantidade;

    public Produto(Integer id, String nome, Double preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double precoTotal(){
        return this.preco * this.quantidade;
    }

    @Override
    public String toString() {
        return "Produto "+ id + "\n" + nome + "\nR$" + preco + "\nQuantidade: " + quantidade + "\n";
    }
}