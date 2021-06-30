package br.com.meli.codigoMorse.controller;

import br.com.meli.codigoMorse.utils.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {
    @GetMapping()
    public String morse(@RequestBody MorseRequest morseRequest){
        return Morse.normal(morseRequest.getCodMorse());
    }
}
