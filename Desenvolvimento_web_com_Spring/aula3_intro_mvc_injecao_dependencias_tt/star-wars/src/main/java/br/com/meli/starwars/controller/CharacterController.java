package br.com.meli.starwars.controller;

import br.com.meli.starwars.entity.Character;
import br.com.meli.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Character>> getCharacter(@PathVariable String name) throws IOException {
        List<Character> character = characterService.getCharacter(name);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }
}
