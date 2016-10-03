package ciphers;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

/**
 * Created by Bethany on 10/2/2016.
 */
public class AlphaCipherTest {
    @Test
    public void shiftArrayLeft() throws Exception {
        // TEST: NORMAL ARRAY
        char[] normalArray = {'a', 'b', 'c'};
        char[] expectedNormalArray = {'b', 'c', 'a'};
        AlphaCipher.shiftArrayLeft(normalArray, 0);
        for(int i = 0; i < expectedNormalArray.length; i++) {
            assertEquals(expectedNormalArray[i], normalArray[i]);
        }

        // TEST: SINGLE ELEMENT ARRAY
        char[] singleElementArray = {'a'};
        char[] expectedSingleElementArray = {'a'};
        AlphaCipher.shiftArrayLeft(singleElementArray, 0);
        for(int i = 0; i < expectedSingleElementArray.length; i++) {
            assertEquals(expectedSingleElementArray[i], singleElementArray[i]);
        }

        //TEST: EMPTY ARRAY
        char[] emptyArray = {};
        char[] expectedEmptyArray = {};
        AlphaCipher.shiftArrayLeft(emptyArray, 0);
        for(int i = 0; i < expectedEmptyArray.length; i++) {
            assertEquals(expectedEmptyArray[i], emptyArray[i]);
        }


    }

    @Test(expected = NullPointerException.class)
    public void shiftArrayLeftHasExceptionOnNull() throws Exception {
        AlphaCipher.shiftArrayLeft(null, 0);
    }

    @Test
    public void buildString() throws Exception {

        //TEST: NORMAL ARRAY
        AlphaCipher testObject = new AlphaCipher();
        char[] normalArray = {'a', 'b', 'c'};
        String expectedNormalString = "abc";
        String normalArrayToString = testObject.buildString(normalArray);
        assertEquals(expectedNormalString, normalArrayToString);

        //TEST: EMPTY ARRAY
        char[] emptyArray = {};
        String expectedEmptyArray = "";
        String emptyArrayToString = testObject.buildString(emptyArray);
        assertEquals(expectedEmptyArray, emptyArrayToString);

    }
}