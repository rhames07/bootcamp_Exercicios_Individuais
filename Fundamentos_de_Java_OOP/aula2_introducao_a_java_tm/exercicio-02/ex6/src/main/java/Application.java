import org.apache.commons.lang3.StringUtils;

public class Application {

    public static class StringUtilModificada extends StringUtils{

        public static String rpad (String s, char c, int n){
            return StringUtils.rightPad(s, n, c);
        }

        public static String ltrim (String s){
            return StringUtils.stripStart(s, null);
        }

        public static String rtrim (String s){
            return StringUtils.stripEnd(s, null);
        }

        public static String trim(String s){
            return StringUtils.trim(s);
        }

        public static int indexOfN (String s, char c, int n){
            String cs = String.valueOf(c);
            return StringUtils.ordinalIndexOf(s, cs, n);
        }
    }

    public static void main(String[] args){
        System.out.println(StringUtilModificada.rpad("teste", '*', 10));
        System.out.println(StringUtilModificada.ltrim("      teste"));
        System.out.println(StringUtilModificada.rtrim("teste         "));
        System.out.println(StringUtilModificada.trim("      teste      "));
        System.out.println(StringUtilModificada.indexOfN("John | Paul | George | Ringo", '|', 2));
    }
}
