/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Syed Irfan
 *
 */
public class LargestValuesFromLabels {

	 public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
         class Item{
            int value;
            int label;
            
            Item(int value, int label){
                this.value = value;
                this.label = label;
            }
        }
        
        List<Item> items = new ArrayList<>();
        
        for(int i = 0; i< values.length; i++){
            items.add(new Item(values[i], labels[i]));
        }
        
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((Item a, Item b) -> b.value - a.value);
        maxHeap.addAll(items);
        
        int count = 0;
        Map<Integer, Integer> labelMap = new HashMap<>();
        
        while(!maxHeap.isEmpty() && num_wanted > 0){
            Item current = maxHeap.remove();
            labelMap.put(current.label, labelMap.getOrDefault(current.label, 0)+1);
            if(labelMap.get(current.label) <= use_limit){
                count += current.value;
                num_wanted--;
            }
        }
        
        
      return count;
    }
	 
}
