package com.challenge.enigma.symbolset;

import org.springframework.stereotype.Component;
import com.challenge.enigma.exceptions.IllegalSymbolException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public final class Klingon implements SymbolSet {

    private final Map<String, String> conversionTable;

    public Klingon() {
        this.conversionTable = loadSymbolSet();
    }

    @Override
    public List<String> transcribe(String name) throws IllegalSymbolException {
        LinkedList<String> klingonEquivalent = new LinkedList<>();

        StringBuilder characterName = new StringBuilder(name);
        String unicode;
        String symbol;
        while (characterName.length() > 0) {
            symbol = String.valueOf(characterName.charAt(0));
            characterName.deleteCharAt(0);

            if (isLetterCorG(symbol)
                    || ((characterName.length() > 0) // out of bounds check
                    && isLetterNG(symbol,
                            String.valueOf(characterName.charAt(0))))) {
                symbol = symbol + characterName.charAt(0);
                characterName.deleteCharAt(0);

            } else if ((characterName.length() > 1) // out of bounds check
                    && (isLetterTLH(symbol,
                            String.valueOf(characterName.charAt(0)),
                            String.valueOf(characterName.charAt(1))))) {
                symbol = symbol
                        + characterName.charAt(0)
                        + characterName.charAt(1);
                characterName.deleteCharAt(0);
                characterName.deleteCharAt(0);
            }

            if (!symbol.equals("q")) {
                symbol = symbol.toUpperCase();
            }

            unicode = conversionTable.get(symbol);

            if (unicode != null) {
                klingonEquivalent.add(unicode);
            } else {
                throw new IllegalSymbolException();
            }
        }
        return klingonEquivalent;
    }

    @Override
    public Map<String, String> loadSymbolSet() {

        Map<String, String> transformationTable;
        transformationTable = new HashMap<>();

        transformationTable.put("A", "0xF8D0");
        transformationTable.put("B", "0xF8D1");
        transformationTable.put("CH", "0xF8D2");
        transformationTable.put("D", "0xF8D3");
        transformationTable.put("E", "0xF8D4");
        transformationTable.put("GH", "0xF8D5");
        transformationTable.put("H", "0xF8D6");
        transformationTable.put("I", "0xF8D7");
        transformationTable.put("J", "0xF8D8");
        transformationTable.put("L", "0xF8D9");
        transformationTable.put("M", "0xF8DA");
        transformationTable.put("N", "0xF8DB");
        transformationTable.put("NG", "0xF8DC");
        transformationTable.put("O", "0xF8DD");
        transformationTable.put("P", "0xF8DE");
        transformationTable.put("q", "0xF8DF");
        transformationTable.put("Q", "0xF8E0");
        transformationTable.put("R", "0xF8E1");
        transformationTable.put("S", "0xF8E2");
        transformationTable.put("T", "0xF8E3");
        transformationTable.put("TLH", "0xF8E4");
        transformationTable.put("U", "0xF8E5");
        transformationTable.put("V", "0xF8E6");
        transformationTable.put("W", "0xF8E7");
        transformationTable.put("Y", "0xF8E8");
        transformationTable.put("'", "0xF8E9");
        transformationTable.put("0", "0xF8F0");
        transformationTable.put("1", "0xF8F1");
        transformationTable.put("2", "0xF8F2");
        transformationTable.put("3", "0xF8F3");
        transformationTable.put("4", "0xF8F4");
        transformationTable.put("5", "0xF8F5");
        transformationTable.put("6", "0xF8F6");
        transformationTable.put("7", "0xF8F7");
        transformationTable.put("8", "0xF8F8");
        transformationTable.put("9", "0xF8F9");
        transformationTable.put(",", "0xF8FD");
        transformationTable.put(".", "0xF8FE");
        transformationTable.put(" ", "0x0020");

        return transformationTable;

    }

    public static boolean isLetterCorG(String letter) {
        switch (letter.toUpperCase()) {
            case "C":
                return true;
            case "G":
                return true;
            default:
                return false;
        }
    }

    public static boolean isLetterNG(String char1, String char2) {
        switch ((char1 + char2).toUpperCase()) {
            case "NG":
                return true;
            default:
                return false;
        }
    }

    public static boolean isLetterTLH(String char1, String char2, String char3) {
        switch ((char1 + char2 + char3).toUpperCase()) {
            case "TLH":
                return true;
            default:
                return false;
        }
    }
}
