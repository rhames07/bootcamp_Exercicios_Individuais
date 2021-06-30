import java.util.Scanner;
import java.util.ArrayList;

public class Application{
    public static void main(String[] args){
        Boolean ehPrimo = true;

        Scanner sc = new Scanner(System.in);
        System.out.print("Insira um número: ");
        int numero = sc.nextInt();  

        ArrayList<Integer> listaDeDevisores = new ArrayList<Integer>();

        for(int i=1;i<=numero;i++){
            if(numero % i == 0){
                listaDeDevisores.add(i);
            }
        }

        for (int divisor : listaDeDevisores){
            if(divisor != 1 && divisor != numero){
                ehPrimo = false;
                break;
            }
        }

        if (ehPrimo){
            System.out.println(numero + " é primo!");
        } else {
            System.out.println(numero + " não é primo!");

        }
    }
}