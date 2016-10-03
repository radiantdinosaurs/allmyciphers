package ciphers;

public class AlphaCipher extends BaseCipher {

	protected char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	AlphaCipher(){
	}

	protected static void shiftArrayLeft(char[] array, int start){
		char temp = array[0];
		for(int j = start; j < array.length -1; j++){
			array[j] = array[j+1];
		}
		for(int j = 0; j < start - 1; j++){
			array[j] = array[j+1];
		}
		array[array.length-1] = temp;
	}

	protected String buildString(char[] array){
		String result = "";
		for(int i = 0; i < array.length; i++){
			result+=Character.toString(array[i]);
		}
		return result;
	}
}
