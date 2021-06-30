public class Application {
    public static void main(String[] args){
        ContaCarrente cc1 = new ContaCarrente("Rhames", "0040", "22548", 200.0);
        ContaCarrente cc2 = new ContaCarrente("Rafa", "0040", "22532", 100.0);
        ContaCarrente cc3 = new ContaCarrente(cc2);

        System.out.println(cc1.toString());
        System.out.println(cc2.toString());
        System.out.println(cc3.toString());

        cc1.deposito(300);
        cc2.deposito(400);
        cc3.deposito(50);

        System.out.println("------ Após depósitos -------");

        System.out.println(cc1.toString());
        System.out.println(cc2.toString());
        System.out.println(cc3.toString());

        cc1.saque(200);
        cc2.saque(100);

        System.out.println("------ Após saques -------");

        System.out.println(cc1.toString());
        System.out.println(cc2.toString());
        System.out.println(cc3.toString());

        cc2.transferencia(cc1, 50);

        System.out.println("------ Após transferência -------");

        System.out.println(cc1.toString());
        System.out.println(cc2.toString());
        System.out.println(cc3.toString());

        cc1.devolucao(cc2, 50);

        System.out.println("------ Após devolução -------");

        System.out.println(cc1.toString());
        System.out.println(cc2.toString());
        System.out.println(cc3.toString());

    }
}
