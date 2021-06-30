import java.util.Scanner;

public class Application{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira um número: ");
        int numero = sc.nextInt();  
        System.out.print("Múltiplo de: ");
        int multiplo = sc.nextInt();  

        int j = 1;
        for(int i=0;i<numero;i++){
            while (j % multiplo != 0){
                j++;
            }
             System.out.println((i + 1) + " = " + j);
            j++;
        }
    }
}