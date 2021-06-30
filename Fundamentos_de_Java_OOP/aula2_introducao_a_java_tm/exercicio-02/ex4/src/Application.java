public class Application {
    public static void main(String[] args){
        Fracao conta = new Fracao();
        System.out.println(conta.adicionar(8,7.5));
        System.out.println(conta.multiplicar(3,5));
        System.out.println(conta.multiplicar(3,9.3));
        System.out.println(conta.subtrair(10,7.5));
        System.out.println(conta.dividir(10,3));
        System.out.println(conta.dividir(8,2.7));
        System.out.println(conta.adicionar(9,10));
    }
}
