package com.challenge.enigma.utilities;

import com.challenge.enigma.symbolset.Klingon;
import com.challenge.enigma.exceptions.SymbolSetNotExistException;
import com.challenge.enigma.exceptions.IllegalSymbolException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranscriptionUtilityTest {

    @Autowired
    private TranscriptionUtility transcriptionUtility;

    @Test(expected = SymbolSetNotExistException.class)
    public void symbolSetNotExistTest()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(null);
        transcriptionUtility.transcribe("");
    }

    @Test
    public void symbolSetExistTestTest()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        Assert.assertNotNull(transcriptionUtility.getSymbolSet());
    }

    @Test(expected = IllegalSymbolException.class)
    public void illegalSymbolTest()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        transcriptionUtility.transcribe("Geordi La Forge");
    }

    @Test
    public void transcribeTestUhura() throws IllegalSymbolException,
            SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        List<String> stringList = transcriptionUtility.transcribe("Uhura");
        Assert.assertEquals(5, stringList.size());
        Assert.assertEquals("0xF8E5", stringList.get(0));
        Assert.assertEquals("0xF8D6", stringList.get(1));
        Assert.assertEquals("0xF8E5", stringList.get(2));
        Assert.assertEquals("0xF8E1", stringList.get(3));
        Assert.assertEquals("0xF8D0", stringList.get(4));
    }

    @Test
    public void transcribeNameContaningTLHInTheMiddleTest()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        List<String> stringList = transcriptionUtility.transcribe("Dartlhson");
        Assert.assertEquals(7, stringList.size());
        Assert.assertEquals("0xF8D3", stringList.get(0));
        Assert.assertEquals("0xF8D0", stringList.get(1));
        Assert.assertEquals("0xF8E1", stringList.get(2));
        Assert.assertEquals("0xF8E4", stringList.get(3));
        Assert.assertEquals("0xF8E2", stringList.get(4));
        Assert.assertEquals("0xF8DD", stringList.get(5));
        Assert.assertEquals("0xF8DB", stringList.get(6));
    }

    @Test
    public void transcribeNameContaningTLHInTheEndTest()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        List<String> stringList = transcriptionUtility.transcribe("Saltertlh");
        Assert.assertEquals(7, stringList.size());
        Assert.assertEquals("0xF8E2", stringList.get(0));
        Assert.assertEquals("0xF8D0", stringList.get(1));
        Assert.assertEquals("0xF8D9", stringList.get(2));
        Assert.assertEquals("0xF8E3", stringList.get(3));
        Assert.assertEquals("0xF8D4", stringList.get(4));
        Assert.assertEquals("0xF8E1", stringList.get(5));
        Assert.assertEquals("0xF8E4", stringList.get(6));
    }

    @Test
    public void transcribeNameContaningCHInTheMiddleTest()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        List<String> stringList = transcriptionUtility.transcribe("Telchev");
        Assert.assertEquals(6, stringList.size());
        Assert.assertEquals("0xF8E3", stringList.get(0));
        Assert.assertEquals("0xF8D4", stringList.get(1));
        Assert.assertEquals("0xF8D9", stringList.get(2));
        Assert.assertEquals("0xF8D2", stringList.get(3));
        Assert.assertEquals("0xF8D4", stringList.get(4));
        Assert.assertEquals("0xF8E6", stringList.get(5));
    }

    @Test
    public void transcribeNameContaningCHInTheEndTest()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        List<String> stringList = transcriptionUtility.transcribe("Jaryn Ch");
        Assert.assertEquals(7, stringList.size());
        Assert.assertEquals("0xF8D8", stringList.get(0));
        Assert.assertEquals("0xF8D0", stringList.get(1));
        Assert.assertEquals("0xF8E1", stringList.get(2));
        Assert.assertEquals("0xF8E8", stringList.get(3));
        Assert.assertEquals("0xF8DB", stringList.get(4));
        Assert.assertEquals("0x0020", stringList.get(5));
        Assert.assertEquals("0xF8D2", stringList.get(6));
    }

    @Test
    public void transcribeNameContaningGHInTheEndTest()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        List<String> stringList = transcriptionUtility.transcribe("Mogh");
        Assert.assertEquals(3, stringList.size());
        Assert.assertEquals("0xF8DA", stringList.get(0));
        Assert.assertEquals("0xF8DD", stringList.get(1));
        Assert.assertEquals("0xF8D5", stringList.get(2));
    }

    @Test
    public void transcribeNameContaningGHInTheMiddleTest()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        List<String> stringList = transcriptionUtility.transcribe("Aghartha");
        Assert.assertEquals(7, stringList.size());
        Assert.assertEquals("0xF8D0", stringList.get(0));
        Assert.assertEquals("0xF8D5", stringList.get(1));
        Assert.assertEquals("0xF8D0", stringList.get(2));
        Assert.assertEquals("0xF8E1", stringList.get(3));
        Assert.assertEquals("0xF8E3", stringList.get(4));
        Assert.assertEquals("0xF8D6", stringList.get(5));
        Assert.assertEquals("0xF8D0", stringList.get(6));
    }

    @Test
    public void transcribeNameContaningGHandNG()
            throws IllegalSymbolException, SymbolSetNotExistException {
        transcriptionUtility.setSymbolSet(new Klingon());
        List<String> stringList = transcriptionUtility.transcribe("Chang");
        Assert.assertEquals(3, stringList.size());
        Assert.assertEquals("0xF8D2", stringList.get(0));
        Assert.assertEquals("0xF8D0", stringList.get(1));
        Assert.assertEquals("0xF8DC", stringList.get(2));
    }
}
