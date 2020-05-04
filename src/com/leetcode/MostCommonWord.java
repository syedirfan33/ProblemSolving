/**
 * 
 */
package com.leetcode;

import java.rmi.server.SocketSecurityException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Syed Irfan
 *
 */
public class MostCommonWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit."
						, new String[] { "hit", "bob" }));
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> bannedWords = new HashSet<>();
		for (String word : banned) {
			bannedWords.add(word);
		}

		String mostFreq = "";
		paragraph = paragraph.replaceAll("[^a-zA-Z]", " ");
		System.out.println(paragraph);
		HashMap<String, Integer> freq = new HashMap<>();
		for (String word : paragraph.split(" ")) {
			String curWord = word.toLowerCase();
			
			int occ = freq.getOrDefault(curWord, 0);
			if (!bannedWords.contains(curWord) && !curWord.trim().equals("")) {
				System.out.println(curWord);
				freq.put(curWord, occ + 1);
			}
			if (occ + 1 > freq.getOrDefault(mostFreq, 0)) {
				mostFreq = curWord;
			}
		}
		System.out.println(freq.toString());
		return mostFreq;
	}

}
