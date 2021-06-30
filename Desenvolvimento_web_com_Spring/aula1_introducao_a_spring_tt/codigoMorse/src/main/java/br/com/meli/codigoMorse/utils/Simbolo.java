package br.com.meli.codigoMorse.utils;

public final class Simbolo {

    public final char normal;
    public final String morse;

    Simbolo(char normal, String morse) {
        this.normal = normal;
        this.morse = morse;
    }

    public static final Simbolo[] SIMBOLOS = new Simbolo[] {
            new Simbolo('A', ".-"),
            new Simbolo('B', "-..."),
            new Simbolo('C', "-.-."),
            new Simbolo('D', "-.."),
            new Simbolo('E', "."),
            new Simbolo('F', "..-."),
            new Simbolo('G', "--."),
            new Simbolo('H', "...."),
            new Simbolo('I', ".."),
            new Simbolo('J', ".---"),
            new Simbolo('K', "-.-"),
            new Simbolo('L', ".-.."),
            new Simbolo('M', "--"),
            new Simbolo('N', "-."),
            new Simbolo('O', "---"),
            new Simbolo('P', ".--."),
            new Simbolo('Q', "--.-"),
            new Simbolo('R', ".-."),
            new Simbolo('S', "..."),
            new Simbolo('T', "-"),
            new Simbolo('U', "..-"),
            new Simbolo('V', "...-"),
            new Simbolo('W', ".--"),
            new Simbolo('X', "-..-"),
            new Simbolo('Y', "-.--"),
            new Simbolo('Z', "--.."),
            new Simbolo('0', "-----"),
            new Simbolo('1', ".---"),
            new Simbolo('2', "..---"),
            new Simbolo('3', "...--"),
            new Simbolo('4', "....-"),
            new Simbolo('5', "....."),
            new Simbolo('6', "-...."),
            new Simbolo('7', "--..."),
            new Simbolo('8', "---.."),
            new Simbolo('9', "----."),
            new Simbolo(' ', "   ")
    };
}
