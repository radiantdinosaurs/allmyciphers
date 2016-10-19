package ciphers;

public class AlphaCipher extends BaseCipher {
	/**
	 * TODO:
	 * Note that this value won't change. What can you do to a class member
	 * whose value does not change and is used across every instance?
	 */
	protected char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	/**
	 * TODO:
	 * When you see constructors without access modifiers, it's good practice
	 * to assign them one.
	 * In this case, default isn't appropriate since it can be moved outside
	 * of the package it's residing in.
	 * "private" is typically used for classes that shouldn't be instantiated.
	 * Private could be appropriate here if we make the Cipher only work with
	 * static methods.
	 * "protected" is normally used for constructors of classes whose constructors
	 * are only called by subclasses.
	 * Therefore, "private" or "public" would be most appropriate.
	 * If you choose to make it private, buildString(char[]) can be made static.
	 * You can do this since buildString(char[]) has no class-level dependencies.
	 */
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
