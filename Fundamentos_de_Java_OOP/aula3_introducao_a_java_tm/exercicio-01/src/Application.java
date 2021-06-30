public class Application {
    public static void main(String[] args){

        Pessoa[] listaDePessoas= {
                new Pessoa("Renata", "35689516815"),
                new Pessoa("Roger", "35689516813"),
                new Pessoa("Ana", "35689516811"),
                new Pessoa("Caio", "35689516814"),
                new Pessoa("Maria", "35689516812"),
                new Pessoa("Jose", "35689516816")};

        SortUtil.sort(listaDePessoas);

        for (Pessoa p : listaDePessoas
             ) {
            System.out.println(p);
        }

        Celular[] listaDeCelulares = {
                new Celular("11999542610", "Vivo"),
                new Celular("11999542432", "Tim"),
                new Celular("11965442610", "Vivo"),
                new Celular("11934872614", "Claro"),
                new Celular("11999543450", "Oi"),
                new Celular("11999542654", "Vivo"),
                new Celular("11999542764", "Vivo"),
        };

        SortUtil.sort(listaDeCelulares);

        for (Celular c : listaDeCelulares
        ) {
            System.out.println(c);
        }
    }
}
