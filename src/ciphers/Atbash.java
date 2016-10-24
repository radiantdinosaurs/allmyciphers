package ciphers;

import java.lang.StringBuilder;

/**
 * Created by Bethany on 9/25/2016.
 * The Atbash class encodes and decodes in Atbash. It is a simple cipher where the letters of the alphabet are
 * reversed, meaning all A's are replaced with Z's, and so on.
 */
public class Atbash {

    /**
     * Takes in a message and encodes it with the Atbash cipher.
     * @param message user-inputted message that needs encoding
     * @return
     */
    public String encode(String message) {
        StringBuilder encodedMessage = new StringBuilder();

        //Encoding the message and appending it to the StringBuilder
        for(char c : message.toCharArray()) {
            char reverse = (char)(('z' - c) + 'a');
            encodedMessage.append(reverse);
        }

        return encodedMessage.toString();
    }

    /**
     * Takes in a message and decodes it with the Atbash cipher.
     * @param message user-inputted message that needs decoding
     * @return
     */
    public String decode(String message) {
        StringBuilder decodedMessage = new StringBuilder();

        //Decoding the message and appending it to the StringBuilder
        for(char c : message.toCharArray()) {
            char reversed = (char)(('a' - c) + 'z');
            decodedMessage.append(reversed);
        }

        return decodedMessage.toString();
    }
}
