/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class CipherEncryptor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static String getCipherEncrypt(String str, int key) {
		char[] res = new char[str.length()];
		int newKey = key%26;
		for(int i=0;i<str.length();i++) {   
			res[i] = getNewLetter(str.charAt(i), newKey);
		}
		return new String(res);
	}

	private static char getNewLetter(char currentWord, int newKey) {
		int newLetterCode = currentWord + newKey;
		return newLetterCode <= 122 ?(char)(newLetterCode) : (char)(96 + newLetterCode%122);
		
	}
}
