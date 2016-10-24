package ciphers;

import javax.swing.JTextArea;

/**
 * The Caesar class encrypts and decrypts in Caesar cipher.
 */
public class Caesar extends AlphaCipher {


	/**
	 * Takes in a message, and replaces each letter of the message with a different letter of the
	 * alphabet, using the shift number to determine how many positions to move further.
	 * @param shift number of positions in the alphabet to shift further
	 * @param message message that needs encoded
	 * @param alphabet all letters of the alphabet
	 * @return encoded message
	 */
	private String encode(int shift, String message, char[] alphabet) {
		char[] messageLetters = message.toCharArray();

		for(int i = 0; i < messageLetters.length; i++){
			for(int j = 0; j < alphabet.length; j++){
				if(Character.toLowerCase(messageLetters[i]) == alphabet[j]){
					messageLetters[i] = alphabet[(j+shift)%alphabet.length];
					break;
				}
			}
		}
		return buildString(messageLetters);
	}

	/**
	 * Takes in a message and decrypts it by replacing each letter of the message with a different
	 * letter of the alphabet, using the shift number to determine how many positions to move backwards.
	 * @param shift number of positions in the alphabet to shift
	 * @param message message that needs decryption
	 * @param alphabet all letters of the alphabet
	 * @return decoded message
	 */
	private String decode(int shift, String message, char[] alphabet) {
		char[] messageLetters = message.toCharArray();

		for(int i = 0; i < messageLetters.length; i++) {
			for(int j = 0; j < alphabet.length; j++) {
				if(Character.toLowerCase(messageLetters[i] ) == alphabet[j]) {
					if(j-shift < 0) {
						messageLetters[i] = alphabet[(((j-shift)%alphabet.length) + alphabet.length)];
						break;
					}
					else messageLetters[i] = alphabet[(j-shift)%alphabet.length];
					break;
				}
			}
		}
		return buildString(messageLetters);
	}

	/**
	 * Checks for and returns an error if the user wants to encrypt a message
	 * less than 2 characters. If there's no error, it calls method encode to encrypt the message.
	 * @param shift number of positions in the alphabet to shift
	 * @param message message that needs decryption
	 * @return decrypted message
	 */
	public String checkForErrorAndPrintEncoded(int shift, String message) {
		if(message.length() < 2) return "Could not cryptify. Soz.";
		String encodedMessage = encode(shift, message, alphabet);

		return encodedMessage;
	}

	/**
	 * Checks for and returns an error if the user wants to decrypt a message
	 * less than 2 characters. If there's no error, it calls caesarDecrypt to decrypt the message.
	 * @param shift number of positions in the alphabet to shift
	 * @param message message that needs decryption
	 * @return decrypted message
	 */
	public String checkForErrorAndPrintDecoded(int shift, String message){
		if(message.length() < 2) return "Could not decrypt. Soz.";
		String decodedMessage;
		decodedMessage = decode(shift, message, alphabet);

		return decodedMessage;
	}

}
