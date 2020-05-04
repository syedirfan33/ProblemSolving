/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input : aaabbcccccdda -> a3b2c5d2a1
		System.out.println(compressor("a"));
		System.out.println(compressor("abcde"));
	}

	public static String compressor(String input) {
		StringBuilder res = new StringBuilder();
		char[] charArr = input.toCharArray();
		boolean isCompressed = false;
		int counter = 1;

		if (input.trim().length() <= 1)
			return input;
		for (int i = 0; i < charArr.length - 1; i++) {
			if (charArr[i] == charArr[i + 1]) {
				counter++;
			} else {
				res.append(charArr[i] + "" + counter);
				counter = 1;
			}
			if (counter > 1)
				isCompressed = true;
		}

		if (charArr[charArr.length - 1] == charArr[charArr.length - 2]) {
			res.append(charArr[charArr.length - 1] + "" + counter);
		} else {
			res.append(charArr[charArr.length - 1] + "" + 1);
		}

		if (!isCompressed)
			return input;
		return res.toString();
	}

}
