/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Irfan
 *
 */
public class WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("penapple");
		System.out.println(sb.indexOf("apple"));
	//	System.out.println(sb.delete(0, 5));
		List<String> dict = Arrays.asList(new String[] {"leet", "code"});
		System.out.println(wordBreak("leetcode", dict));
	}
	public static boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i=1; i<len+1; i++) {
            for (int j=0; j<i; j++)
                if (f[j] && wordDict.contains(s.substring(j,i)))
                {
                    f[i] = true;
                    break;
                }
        }
        System.out.println(Arrays.toString(f));
        return f[len];
	}
}
