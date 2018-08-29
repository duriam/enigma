package com.challenge.enigma.models;

/**
 * This class is utilized from species information on the last step of STAPI 
 * interaction.
 * @author Riza DOGAN <rizadoogan@gmail.com>
 */
public class CharacterSpecies {

    private String uid;
    private String name;

    /**
     * Getter method for CharacterSpecies's uid
     * @return uid type : String
     */
    public String getUid() {
        return uid;
    }

    /**
     * Setter method for CharacterSpecies's uid
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Getter method for CharacterSpecies's name
     * @return name type : String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for CharacterSpecies's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
