import java.util.Arrays;
import java.util.Collections;

public class Application{
    public static void main(String[] args){
        Integer[] array = {52, 10, 85, 1324, 01, 13, 62, 30, 12, 127};

        Arrays.sort(array); 
        System.out.println("Crescente : " + Arrays.toString(array));

        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("Decrescente : " + Arrays.toString(array));
    }
}