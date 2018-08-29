package com.challenge.enigma.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.challenge.enigma.models.Character;
import com.challenge.enigma.models.CharacterList;
import com.challenge.enigma.models.CharacterRoot;
import com.challenge.enigma.models.CharacterSpecies;

/**
 *
 * @author Riza DOGAN <rizadoogan@gmail.com>
 */
@Service
public class SpeciesAPIUtility {

    @Autowired
    private RestTemplate rest;
    private final String URL = "http://stapi.co/api/v1/rest/character";

    /**
     * POST request utilizing stapi. Example of request body;
     * "title=Uhura&name=Uhura"
     * @param characterName
     * @return characterList - baseline information for character
     */
    public CharacterList getCharacterList(String characterName) {
        CharacterList characterList;
        String requestParameters = "title=" + characterName
                + "&name=" + characterName;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> request = new HttpEntity<>(requestParameters, headers);
        characterList = rest.postForObject(URL + "/search", request, CharacterList.class);
        return characterList;
    }

    /**
     * Parses JSON to get baseline characters from the first request
     * @param characterList
     * @return species type : String
     */
    public String getSpecies(CharacterList characterList) {
        String species = "";
        boolean isSpeciesExist = false;
        Character character;
        for (Character characterBuffer : characterList.getCharacters()) {
            character = getCharacterByUID(characterBuffer.getUid());
            for (CharacterSpecies characterSpecies
                    : character.getCharacterSpecies()) {
                if (characterSpecies.getName() != null
                        && !characterSpecies.getName().isEmpty()) {
                    species = characterSpecies.getName();
                    isSpeciesExist = true;
                    break;
                }
            }
            if (isSpeciesExist) {
                break;
            }
        }
        return species;
    }

    /**
     * GET Requests utilizing stapi. stapi returns detailed information on the 
     * character via UID
     * @param uid
     * @return a new Character - Detailed information on character from stapi
     */
    private Character getCharacterByUID(String uid) {
        String uidRequest = "uid=" + uid;
        CharacterRoot characterRoot = this.rest.getForObject(this.URL + "?"
                + uidRequest, CharacterRoot.class);
        if (characterRoot != null) {
            return characterRoot.getCharacter();
        }
        return new Character();
    }
}
