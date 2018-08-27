package com.challenge.enigma.symbolset;

import com.challenge.enigma.exceptions.IllegalSymbolException;
import java.util.List;
import java.util.Map;

public interface SymbolSet {

    List<String> transcribe(String word) throws IllegalSymbolException;

    Map<String, String> loadSymbolSet();
}
