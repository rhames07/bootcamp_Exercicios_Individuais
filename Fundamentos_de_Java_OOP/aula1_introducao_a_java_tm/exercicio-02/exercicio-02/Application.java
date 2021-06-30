import java.time.LocalDate;

public class Application{
    public static void main(String[] args){
        Empresa X = new Empresa("X", LocalDate.of(2021, 1,1),1.13);
        Empresa Y = new Empresa("Y", LocalDate.of(2021, 1,1),18.4);

        while(Y.getValor() > X.getValor()){
            System.out.println("----------------------------------------------------");
            X.setValor(X.valorizacao(X.getValor(), 1.48));
            Y.setValor(Y.valorizacao(Y.getValor(), 0.32));

            X.setData(X.getData().plusYears(1));
            Y.setData(Y.getData().plusYears(1));

            System.out.println(X.toString());
            System.out.println(Y.toString());
        }
    }
}