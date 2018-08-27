package com.challenge.enigma;

import com.challenge.enigma.symbolset.Klingon;
import com.challenge.enigma.exceptions.SymbolSetNotExistException;
import com.challenge.enigma.exceptions.IllegalSymbolException;
import com.challenge.enigma.models.CharacterList;
import java.util.List;

public class EnigmaMainProgram  {
    public static void main(String[] args) {
        String argumentsPassedFromBash = "";
        if (args.length > 0) {
            try {
                argumentsPassedFromBash = String.join(" ", args);
                transcriptionUtility.setSymbolSet(new Klingon());
                List<String> transcription = transcriptionUtility.transcribe(argumentsPassedFromBash);
                System.out.println(String.join(" ", transcription));
            } catch (SymbolSetNotExistException e) {
                System.out.println("Symbol set does not exist.");
            } catch (IllegalSymbolException e) {
                System.out.println(argumentsPassedFromBash + " contains illegal characters, transcriber exiting...");
            }

        } else {
            System.out.println("Atleast one argument has to be passed, exiting...");
        }
    }
}
