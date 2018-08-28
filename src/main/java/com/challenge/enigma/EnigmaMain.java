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

@SpringBootApplication
public class EnigmaMain implements CommandLineRunner {

    @Autowired
    public TranscriptionUtility transcriptionUtility;

    @Autowired
    public SpeciesAPIUtility speciesAPIUtility;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(EnigmaMain.class, args);
    }

    @Override
    public void run(String... args) {
        String argumentsPassedFromBash = "";
        if (args.length > 0) {
            try {
                argumentsPassedFromBash = String.join(" ", args);
                transcriptionUtility.setSymbolSet(new Klingon());
                List<String> transcription = transcriptionUtility.transcribe(argumentsPassedFromBash);
                System.out.println(String.join(" ", transcription));
                CharacterList characterList = speciesAPIUtility.getCharacterList(argumentsPassedFromBash);
                String species = speciesAPIUtility.getSpecies(characterList);
                System.out.println(!species.isEmpty() ? species : "Species is not found.");
            } catch (SymbolSetNotExistException e) {
                System.out.println("Symbol set does not exist.");
            } catch (IllegalSymbolException e) {
                System.out.println(argumentsPassedFromBash + " contains illegal characters, transcriber exiting.");
            }
        } else {
            System.out.println("Atleast one argument has to be passed, exiting...");
        }

    }
}
