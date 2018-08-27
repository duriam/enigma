package com.challenge.enigma.symbolset;

import java.util.List;
import java.util.Map;

public interface SymbolSet {
    List<String> transcribe(String word);
    Map<String, String> loadSymbolSet();
}
