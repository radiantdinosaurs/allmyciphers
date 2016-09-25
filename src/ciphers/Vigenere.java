package ciphers;

import javax.swing.JTextArea;

public class Vigenere extends AlphaCipher {
/********************************************
 * Local Variables
 ********************************************/
private String keyword;
private char[][] table;

/********************************************
 * Constructors
 ********************************************/
public Vigenere(){
	initTable();
}

/********************************************
 * ALL METHODS
 ********************************************/

/********************************************
 * -> Supplemental Methods
 ********************************************/
//initiates the 2d matrix for the cipher
protected void initTable(){
	table = new char[alphabet.length][alphabet.length];
	
	//create original row
	for(int i = 0; i < table.length; i++){
		table[0][i] = alphabet[i];
	}//endfor
	
	//create every other row
	for(int i = 1; i < table.length; i++){
		shiftArrayLeft(alphabet, alphabet.length);
		
		for(int j = 0; j < table.length; j++){
			table[i][j] = alphabet[j];
		}//endfor
	}//endfor
}//end initTable

protected char[] maskString(String keyword, String message){
	char[] mask = new char[message.length()];
	
	for(int i = 0, j = 0; i < message.length(); i++, j++){
		if(message.charAt(i)==' ') continue;
		if(j >= keyword.length()) j = 0;
		mask[i] = Character.toLowerCase(keyword.charAt(j));
	}
	return mask;
}//end maskString

/********************************************
 * -> Algorithms
 ********************************************/
private String vigenere(String keyword, String message, char[][] alphabet){
	
	char[] mask = maskString(keyword, message);

	String result="";
	for(int i = 0; i < message.length(); i++){
		if(message.charAt(i)==' '){ result+=" "; continue;}
		int matchX=0, matchY=0;
		
		for(int j = 0; j < alphabet.length; j++){
			if(mask[i]==alphabet[j][0]) {
				matchY = j; break;
			}
		}
		for(int j = 0; j < alphabet.length; j++){
			if(Character.toLowerCase(message.charAt(i))==alphabet[0][j]) {
				matchX = j; break;
			}
		}
		result+=alphabet[matchY][matchX];
	}
	return result;
}//end vigenere

private String undoVigenere(String keyword, String message, char[][] alphabet){
	String result = "";
	char[] mask = maskString(keyword, message);
	int matchX = 0, matchXPrime = 0;
	for(int i = 0; i < mask.length; i++){
		if(message.charAt(i)==' ' || mask[i]==' '){ result+=" "; continue;}
		
		for(int j = 0; j < alphabet.length; j++){
			if(Character.toLowerCase(mask[i])==alphabet[0][j]){
				matchX = j; break;
			}//endif
		}
		for(int j = 0; i < alphabet.length; j++){
			if(Character.toLowerCase(message.charAt(i))==alphabet[j][matchX]){
				matchXPrime = j; break;
			}//endif
		}
		
		result+=alphabet[0][matchXPrime];
	}

	return result;
}//end undoVigenere

/********************************************
 * -> Public Methods
 ********************************************/
public String cryptify(String keyword, String message, JTextArea outputArea) {
	if(message.length() < 2 || keyword.length() < 2) return "Could not encrypt. Soz.";
	String result;
	outputArea.append("Cryptifying..."+"\n");
	result = vigenere(keyword, message, table);
	
	outputArea.append("Done!"+"\n");
	outputArea.append("Proceeding to post..."+"\n");
	return result;
}//end cryptify

public String decryptify(String keyword, String cipherText, JTextArea outputArea){
	if(cipherText.length() < 2 || keyword.length() < 2) return "Could not decipher. Soz.";
	String result;
	outputArea.append("Decryptifying..."+"\n");
	result = undoVigenere(keyword, cipherText, table);
	
	outputArea.append("Done!"+"\n");
	outputArea.append("Proceeding to post..."+"\n");	
	return result;
}//end decryptify


}
