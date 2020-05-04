/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Irfan
 *
 */
public class GroupAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] in = { "eat", "tea", "tan", "ate", "nat", "bat" };

		System.out.println(groupAnagrams(in));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> anaMap = new HashMap<>();
		for (String current : strs) {
			char[] charArr = current.toCharArray();
			Arrays.sort(charArr);
			String sortedStr = new String(charArr);
			if (!anaMap.containsKey(sortedStr)) {
				anaMap.put(sortedStr, new ArrayList<>());
			}
			anaMap.get(sortedStr).add(current);

		}
		result.addAll(anaMap.values());
		return result;
	}

}
