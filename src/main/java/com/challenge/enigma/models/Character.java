package com.challenge.enigma.models;

import java.util.List;

public class Character {

    private String uid;
    private String name;
    private List<CharacterSpecies> characterSpecies;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CharacterSpecies> getCharacterSpecies() {
        return characterSpecies;
    }

    public void setCharacterSpecies(List<CharacterSpecies> characterSpecies) {
        this.characterSpecies = characterSpecies;
    }
}
