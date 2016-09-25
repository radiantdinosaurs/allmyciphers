package ciphers;

import javax.swing.*;
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
     * @param outputArea GUI used to display messages to user
     * @return
     */
    public String encode(String message, JTextArea outputArea) {
        StringBuilder encodedMessage = new StringBuilder();

        //Letting the user know the message is going to start being encoded
        outputArea.append("Decryptifying..." + "\n");

        //Encoding the message and appending it to the StringBuilder
        for(char c : message.toCharArray()) {
            char reverse = (char)(('z' - c) + 'a');
            encodedMessage.append(reverse);
        }

        //Letting the user know that the message is encoded
        outputArea.append("Done!" + "\n");

        return encodedMessage.toString();
    }

    /**
     * Takes in a message and decodes it with the Atbash cipher.
     * @param message
     * @param outputArea
     * @return
     */
    public String decode(String message, JTextArea outputArea) {
        StringBuilder decodedMessage = new StringBuilder();

        //Letting the user know the message is going to start being decoded
        outputArea.append("Decryptifying..." + "\n");

        //Decoding the message and appending it to the StringBuilder
        for(char c : message.toCharArray()) {
            char reversed = (char)(('a' - c) + 'z');
            decodedMessage.append(reversed);
        }

        //Letting the user know that the message is decoded
        outputArea.append("Done!" + "\n");

        return decodedMessage.toString();
    }
}
