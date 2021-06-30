import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {
    private GregorianCalendar data;

    public Data(int year, int month, int dayOfMonth) {
        GregorianCalendar data = new GregorianCalendar(year, month, dayOfMonth);
        this.data = data;
    }

    public Data() {
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public boolean dataEstaCorreta(int year, int month, int dayOfMonth){
        GregorianCalendar dataTeste = new GregorianCalendar(year, month, dayOfMonth);
        if ((dataTeste.get(Calendar.DAY_OF_MONTH) == data.get(Calendar.DAY_OF_MONTH) &&
                (dataTeste.get(Calendar.MONTH) == data.get(Calendar.MONTH) &&
                        (dataTeste.get(Calendar.YEAR) == data.get(Calendar.YEAR)
        )))){
            return true;
        } else {
            return false;
        }
    }

    public GregorianCalendar adicionaDia(){
        data.add(Calendar.DAY_OF_MONTH, 1);
        return this.data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dia=" + data.get(Calendar.DAY_OF_MONTH) + ", " +
                "mes=" + data.get(Calendar.MONTH) + ", " +
                "ano=" + data.get(Calendar.YEAR) +
                '}';
    }

    public static void main(String[] args){
        Data data = new Data(2021,1,1);
        System.out.println("------ Data ------");
        System.out.println(data.toString());
        data.adicionaDia();
        System.out.println("------ Data após adicionar dia ------");
        System.out.println(data.toString());
        System.out.println("------ Compara Datas ------");
        System.out.println(data.dataEstaCorreta(2021,1,2));
    }
}
