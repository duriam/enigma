package com.challenge.enigma.symbolset;

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
public class KlingonTest {

    @Autowired
    SymbolSet klingonSymbolSet;

    @Test
    public void transcribeTestEmpty() throws IllegalSymbolException {
        List<String> stringList = klingonSymbolSet.transcribe("");
        Assert.assertEquals(0, stringList.size());
    }

    @Test(expected = IllegalSymbolException.class)
    public void transcribeTestGeordiLaForg() throws IllegalSymbolException {
        List<String> stringList = klingonSymbolSet.transcribe("Geordi La Forg");
    }

    @Test
    public void transcribeTestUhura() throws IllegalSymbolException {
        List<String> stringList = klingonSymbolSet.transcribe("Uhura");
        Assert.assertEquals(5, stringList.size());
        Assert.assertEquals("0xF8E5", stringList.get(0));
        Assert.assertEquals("0xF8D6", stringList.get(1));
        Assert.assertEquals("0xF8E5", stringList.get(2));
        Assert.assertEquals("0xF8E1", stringList.get(3));
        Assert.assertEquals("0xF8D0", stringList.get(4));
    }

    @Test
    public void transcribeTestBElannaTorres() throws IllegalSymbolException {
        List<String> stringList = klingonSymbolSet.transcribe("B'Elanna Torres");
        Assert.assertEquals(15, stringList.size());
        Assert.assertEquals("0xF8D1", stringList.get(0));
        Assert.assertEquals("0xF8E9", stringList.get(1));
        Assert.assertEquals("0xF8D4", stringList.get(2));
        Assert.assertEquals("0xF8D9", stringList.get(3));
        Assert.assertEquals("0xF8D0", stringList.get(4));
        Assert.assertEquals("0xF8DB", stringList.get(5));
        Assert.assertEquals("0xF8DB", stringList.get(6));
        Assert.assertEquals("0xF8D0", stringList.get(7));
        Assert.assertEquals("0x0020", stringList.get(8));
        Assert.assertEquals("0xF8E3", stringList.get(9));
        Assert.assertEquals("0xF8DD", stringList.get(10));
        Assert.assertEquals("0xF8E1", stringList.get(11));
        Assert.assertEquals("0xF8E1", stringList.get(12));
        Assert.assertEquals("0xF8D4", stringList.get(13));
        Assert.assertEquals("0xF8E2", stringList.get(14));
    }
}
