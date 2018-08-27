package com.challenge.enigma.utilities;

import org.springframework.stereotype.Service;
import com.challenge.enigma.symbolset.SymbolSet;
import com.challenge.enigma.exceptions.SymbolSetNotExistException;
import com.challenge.enigma.exceptions.IllegalSymbolException;
import java.util.List;

@Service
public class TranscriptionUtility {

    private SymbolSet symbolSet;

    public void setSymbolSet(SymbolSet symbolSet) {
        this.symbolSet = symbolSet;
    }

    public SymbolSet getSymbolSet() {
        return symbolSet;
    }

    public List<String> transcribe(String name) throws
            SymbolSetNotExistException, IllegalSymbolException {
        if (this.symbolSet == null) {
            throw new SymbolSetNotExistException();
        }
        return this.symbolSet.transcribe(name);
    }
}
