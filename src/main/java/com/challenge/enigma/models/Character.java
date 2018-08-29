package com.challenge.enigma.models;

import java.util.List;

/**
 * This class is generated from detailed character information (via UID) 
 * @author Riza DOGAN <rizadoogan@gmail.com>
 */
public class Character {

    private String uid;
    private String name;
    private List<CharacterSpecies> characterSpecies;

    /**
     * Getter method for Character class's UID information
     * @return UID type : String
     */
    public String getUid() {
        return uid;
    }

    /**
     * Setter method for Character class's UID information
     * @param uid 
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Getter method for Character class's Name
     * @return name type : String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for Character class's Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for Character class's Species information
     * @return characterSpecies type : List<CharacterSpecies>
     */
    public List<CharacterSpecies> getCharacterSpecies() {
        return characterSpecies;
    }

    /**
     * Setter method for Character class's Species information
     * @param characterSpecies
     */
    public void setCharacterSpecies(List<CharacterSpecies> characterSpecies) {
        this.characterSpecies = characterSpecies;
    }
}
