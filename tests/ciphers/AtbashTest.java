package ciphers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Bethany Corder on 10/2/2016.
 */
public class AtbashTest {
    @Test
    public void encode() throws Exception {

        //TEST: NORMAL STRING
        Atbash testObject = new Atbash();
        String normalMessage = "abc";
        String expectedNormalMessage = "zyx";
        normalMessage = testObject.encode(normalMessage);
        assertEquals(expectedNormalMessage, normalMessage);

        //TEST: SINGLE ELEMENT STRING
        String singleElementMessage = "a";
        String expectedSingleElementMessage = "z";
        singleElementMessage = testObject.encode(singleElementMessage);
        assertEquals(expectedSingleElementMessage, singleElementMessage);

        //TEST: EMPTY STRING
        String emptyString = "";
        String expectedEmptyString = "";
        emptyString = testObject.encode(emptyString);
        assertEquals(expectedEmptyString, emptyString);

    }

    @Test
    public void decode() throws Exception {

        //TEST: NORMAL STRING
        Atbash testObject = new Atbash();
        String normalMessage = "zyx";
        String expectedNormalMessage = "abc";
        normalMessage = testObject.decode(normalMessage);
        assertEquals(expectedNormalMessage, normalMessage);

        //TEST: SINGLE ELEMENT STRING
        String singleElementMessage = "z";
        String expectedSingleElementMessage = "a";
        singleElementMessage = testObject.decode(singleElementMessage);
        assertEquals(expectedSingleElementMessage, singleElementMessage);

        //TEST: EMPTY STRING
        String emptyString = "";
        String expectedEmptyString = "";
        emptyString = testObject.decode(emptyString);
        assertEquals(expectedEmptyString, emptyString);

    }
}
