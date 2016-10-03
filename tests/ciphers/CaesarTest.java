package ciphers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bethany Corder on 10/2/2016.
 */
public class CaesarTest {
    @Test
    public void checkForErrorAndPrintEncoded() throws Exception {
        Caesar testObject = new Caesar();

        //TEST: NORMAL STRING
        String normalMessage = "abc";
        String expectedMessage = "bcd";
        normalMessage = testObject.checkForErrorAndPrintEncoded(1, normalMessage);
        assertEquals(expectedMessage, normalMessage);

        //TEST: EMPTY STRING
        String emptyMessage = "";
        String expectedEmptyMessage = "Could not cryptify. Soz.";
        emptyMessage = testObject.checkForErrorAndPrintEncoded(0, emptyMessage);
        assertEquals(expectedEmptyMessage, emptyMessage);
    }

    @Test
    public void checkForErrorAndPrintDecoded() throws Exception {
        Caesar testObject = new Caesar();

        //TEST: NORMAL STRING
        String normalMessage = "bcd";
        String expectedMessage = "abc";
        normalMessage = testObject.checkForErrorAndPrintDecoded(1, normalMessage);
        assertEquals(expectedMessage, normalMessage);

        //TEST: EMPTY STRING
        String emptyMessage = "";
        String expectedEmptyMessage = "Could not decrypt. Soz.";
        emptyMessage = testObject.checkForErrorAndPrintDecoded(0, emptyMessage);
        assertEquals(expectedEmptyMessage, emptyMessage);

    }

}