package br.com.meli.starwars.service;

import br.com.meli.starwars.entity.Character;
import br.com.meli.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getCharacter(String name) throws IOException {
        return characterRepository.getCharacterByName(name);
    }
}
