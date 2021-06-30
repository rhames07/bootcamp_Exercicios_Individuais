import java.util.Scanner;
import java.util.ArrayList;

public class Application{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira um número: ");
        int numero = sc.nextInt();  

        int j = 1;
        for (int i=0;i<numero;i++){
            while(ehPrimo(j) == false){
                j++;
            }
            System.out.println(j);
            j++;
        }
    }

    public static Boolean ehPrimo(int numero){
            Boolean ehPrimo = true;
            if (numero == 1) return false;

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
            return ehPrimo;
        }
}