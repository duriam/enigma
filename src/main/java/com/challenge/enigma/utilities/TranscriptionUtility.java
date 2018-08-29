package com.challenge.enigma.utilities;

import org.springframework.stereotype.Service;
import com.challenge.enigma.symbolset.SymbolSet;
import com.challenge.enigma.exceptions.SymbolSetNotExistException;
import com.challenge.enigma.exceptions.IllegalSymbolException;
import java.util.List;

/**
 *
 * @author kiriktarak
 */
@Service
public class TranscriptionUtility {

    private SymbolSet symbolSet;

    /**
     *
     * @param symbolSet
     */
    public void setSymbolSet(SymbolSet symbolSet) {
        this.symbolSet = symbolSet;
    }

    /**
     *
     * @return
     */
    public SymbolSet getSymbolSet() {
        return symbolSet;
    }

    /**
     *
     * @param name
     * @return
     * @throws SymbolSetNotExistException
     * @throws IllegalSymbolException
     */
    public List<String> transcribe(String name) throws
            SymbolSetNotExistException, IllegalSymbolException {
        if (this.symbolSet == null) {
            throw new SymbolSetNotExistException();
        }
        return this.symbolSet.transcribe(name);
    }
}
