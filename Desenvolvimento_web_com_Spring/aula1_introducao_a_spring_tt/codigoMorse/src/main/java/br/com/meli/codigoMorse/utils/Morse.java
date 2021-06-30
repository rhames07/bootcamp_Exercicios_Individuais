package br.com.meli.codigoMorse.utils;

public final class Morse {

    private Morse() {}

    public static String normal(String morse) {
        StringBuilder textNormal = new StringBuilder();
        String[] palavrasMorse = morse.split("\\Q   \\E");
        for (String palavraMorse : palavrasMorse) {
            if (textNormal.length() > 0) {
                textNormal.append(" ");
            }
            String[] letrasMorse = palavraMorse.trim().split(" ");
            for (String letraMorse : letrasMorse) {
                textNormal.append(letraNormal(letraMorse));
            }
        }
        return textNormal.toString();
    }

    private static char letraNormal(String morse) {
        for (Simbolo simbolo : Simbolo.SIMBOLOS) {
            if (simbolo.morse.equals(morse)) {
                return simbolo.normal;
            }
        }
        throw new IllegalArgumentException("Símbolo inválido: \"" + morse + "\"");
    }
}