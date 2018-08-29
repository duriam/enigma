package com.challenge.enigma.symbolset;

import com.challenge.enigma.exceptions.IllegalSymbolException;
import java.util.List;
import java.util.Map;

/**
 * Generic interface for SymbolSets, can be used to extend language capabilities
 * of transcriber.
 * @author Riza DOGAN <rizadoogan@gmail.com>
 */
public interface SymbolSet {

    /**
     * Abstract transcribe class utilizing symbol tables
     * @param name type : String
     * @return List<String>
     * @throws IllegalSymbolException
     */
    List<String> transcribe(String name) throws IllegalSymbolException;

    /**
     * Abstract class to implement one to one symbol tables
     * @return
     */
    Map<String, String> loadSymbolSet();
}
