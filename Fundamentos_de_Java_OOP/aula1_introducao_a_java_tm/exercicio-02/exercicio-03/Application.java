import java.util.ArrayList;
import java.util.Scanner;

public class Application{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();

        for(Integer i = 0; i<3;i++){
            System.out.println("-------------------------------------");
            System.out.println("Digite as informações pro produto " + (i+1));
            System.out.print("Produto: ");
            String nome = sc.next();
            System.out.print("Preço: ");
            Double preco = sc.nextDouble();
            System.out.print("Quantidade: ");
            Integer quantidade = sc.nextInt();
            listaDeProdutos.add(new Produto(i+1, nome, preco, quantidade));
        }
        sc.close();

        System.out.println("----------- RESPOSTA ---------");
        Double totalDaCompra = 0.0;
        for (Produto produto : listaDeProdutos) {
            System.out.println(produto.toString()); 
            totalDaCompra = totalDaCompra + produto.precoTotal();
        }
        System.out.println("Valor Total: R$" + totalDaCompra);
    }
}