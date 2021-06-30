public class Application {
    public static void main(String[] args){
        Counter c1 = new Counter(1);
        Counter c2 = new Counter(c1);

        System.out.println("------ Números --------");

        System.out.println(c1.toString());
        System.out.println(c2.toString());


        System.out.println("------ Após Adicionar Valores --------");

        c1.adicionaValorEmNumero(5);
        c2.adicionaValorEmNumero(3);

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println("------ Após Subtrair Valores --------");

        c1.subtraiValorDeNumero(3);
        c2.subtraiValorDeNumero(1);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
