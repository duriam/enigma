package com.challenge.enigma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.challenge.enigma.symbolset.Klingon;
import com.challenge.enigma.exceptions.SymbolSetNotExistException;
import com.challenge.enigma.exceptions.IllegalSymbolException;
import com.challenge.enigma.models.CharacterList;
import com.challenge.enigma.utilities.TranscriptionUtility;
import com.challenge.enigma.utilities.SpeciesAPIUtility;
import java.util.List;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author Riza DOGAN <rizadoogan@gmail.com>
 */
@SpringBootApplication
@EnableAsync
public class EnigmaMain implements CommandLineRunner {

    @Autowired
    public TranscriptionUtility transcriber;

    @Autowired
    public SpeciesAPIUtility stapiClient;

    /**
     *
     * @param builder - Spring framework's central class for synchronous
     * client-side HTTP access template
     * @return will attempt to use the most suitable ClientHttpRequestFactory
     * Builds a new RestTemplate instance and configures it using this builder.
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     *
     * @param argumentsPassedFromBash - Passed from the shell script(bash) 
     * Assumed to be the names of the characters
     */
    public static void main(String[] argumentsPassedFromBash) {
        SpringApplication.run(EnigmaMain.class, argumentsPassedFromBash);
    }

    /**
     * 
     * @param argumentsPassedFromBash - Passed from the shell script(bash) 
     * Assumed to be the names of the characters
     */
    @Override
    public void run(String... argumentsPassedFromBash) {
        String args = "";
        try {
            // Input sanitation (Not in security aspect, rather functional)
            args = String.join(" ", argumentsPassedFromBash).trim();
            if (args.isEmpty()) {
                System.out.println("Atleast one argument has to be passed, program exiting...");
            } else {
                // Transcriber is called with klingon symbolset
                transcriber.setSymbolSet(new Klingon());
                List<String> transcription = transcriber.transcribe(args);
                System.out.println(String.join(" ", transcription));
                // Stapi client is called with POST method containing character 
                // name, returns JSON containing characters
                CharacterList characterList = stapiClient.getCharacterList(args);
                // Stapi client called with character to get UID, 
                // which is used for getting JSON containing species information 
                String species = stapiClient.getSpecies(characterList);
                System.out.println(!species.isEmpty() ? species : "Species is not found.");
            }
        } catch (SymbolSetNotExistException e) {
            System.out.println("Symbol set does not exist.");
        } catch (IllegalSymbolException e) {
            System.out.println(args + " contains illegal characters, program exiting...");
        }

    }
}
