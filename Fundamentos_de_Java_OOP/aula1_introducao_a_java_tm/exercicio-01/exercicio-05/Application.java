import java.util.Scanner;
import java.util.ArrayList;

public class Application{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantidade de números: ");
        int qntNumeros = sc.nextInt();  
        System.out.print("Pelo menos N digitos: ");
        int numDeDigitos = sc.nextInt();  
        System.out.print("Dígito: ");
        int digito = sc.nextInt();  

        int contadorQntNumeros = 0;

        for(int numeroAtual=0;contadorQntNumeros<qntNumeros;numeroAtual++){
            String stringNumeroAtual = String.valueOf(numeroAtual);
            String[] arrNumeroAtual = stringNumeroAtual.split("");

            int contadorDeDigitos = 0;
            for(int i=0;i<arrNumeroAtual.length;i++){
                if(arrNumeroAtual[i].equals(String.valueOf(digito))){
                    contadorDeDigitos++;
                } 
            }

            if (contadorDeDigitos >= numDeDigitos){
                System.out.println(numeroAtual);
                contadorQntNumeros++;
            }
        }
    }
}