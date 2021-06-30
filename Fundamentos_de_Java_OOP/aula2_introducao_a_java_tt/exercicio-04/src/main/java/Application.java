public class Application {
    public static void main(String[] args){
        Pj pj1 = new Pj(100, 100);
        pj1.pagarSalario();
        System.out.println(pj1);

        Clt tecnico = new Clt(Hierarquia.TECNICO, 1);
        tecnico.pagarSalario();
        System.out.println(tecnico);

        Clt analista = new Clt(Hierarquia.ANALISTA, 1);
        analista.pagarSalario();
        System.out.println(analista);

        Clt gerente = new Clt(Hierarquia.GERENTE, 1);
        gerente.pagarSalario();
        System.out.println(gerente);

        Clt diretor = new Clt(Hierarquia.DIRETOR, 10000.0);
        diretor.pagarSalario();
        System.out.println(diretor);
    }
}
