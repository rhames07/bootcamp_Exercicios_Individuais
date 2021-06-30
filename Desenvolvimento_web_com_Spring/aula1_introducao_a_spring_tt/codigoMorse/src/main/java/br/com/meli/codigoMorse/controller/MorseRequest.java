package br.com.meli.codigoMorse.controller;

public class MorseRequest {
    private String codMorse;

    public MorseRequest() {
    }

    public MorseRequest(String codMorse) {
        this.codMorse = codMorse;
    }

    public String getCodMorse() {
        return codMorse;
    }

    public void setCodMorse(String codMorse) {
        this.codMorse = codMorse;
    }

    @Override
    public String toString() {
        return "MorseRequest{" +
                "codMorse='" + codMorse + '\'' +
                '}';
    }
}
