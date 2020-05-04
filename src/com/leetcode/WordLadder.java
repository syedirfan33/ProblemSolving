/**
 * 
 */
package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Syed Irfan
 *
 */
public class WordLadder {

	  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        Set<String> set = new HashSet<>();
	        for(String word: wordList){
	            set.add(word);
	        }
	        if(!set.contains(endWord)) return 0;
	        Queue<String> queue = new LinkedList<>();
	        queue.add(beginWord);
	        int level = 1;
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i=0;i<size;i++){
	                String cur = queue.remove();
	                char[] cur_arr = cur.toCharArray();
	                for(int j=0;j<cur_arr.length;j++){
	                    char ori_char = cur_arr[j];
	                    for(char c='a';c<='z';c++){
	                        if(c==ori_char) continue;
	                        cur_arr[j] = c;
	                        String new_str = String.valueOf(cur_arr);
	                        if(new_str.equals(endWord)) return level + 1;
	                        if(set.contains(new_str)){
	                            set.remove(new_str);
	                            queue.add(new_str);
	                        }
	                    }
	                  cur_arr[j] = ori_char;  
	                }
	            }
	            level++;

	        }
	        return 0;
	    }
}
