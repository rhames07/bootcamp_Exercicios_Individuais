package br.com.meli.starwars.repository;

import br.com.meli.starwars.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository {
    private static final File FILE = new File("starwars.json");

    private final ObjectMapper mapper;

    @Autowired
    public CharacterRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Character> getCharacterByName(String name) throws IOException {
        List<Character> characters;
        FileInputStream inputStream = new FileInputStream(FILE);
        TypeReference<List<Character>> typeReference = new TypeReference<>(){};
        characters = mapper.readValue(inputStream, typeReference);
        inputStream.close();

        List<Character> character =  characters.stream().filter(c -> c.getName()
                .toLowerCase()
                .contains(name.toLowerCase())).collect(Collectors.toList());

        if (character.isEmpty()){
            throw new IllegalStateException("Personagem não encontrado.");
        }

        return character;
    }
}
