/**
 * 
 */
package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Irfan
 *
 */
public class DFS {

	static class Node {
		String name;
		List<Node> children = new ArrayList<>();
		
		public Node(String name) {
			this.name = name;
		}
		
		public List<String> dfs(List<String> array){
			array.add(this.name);
			
			for(int i=0;i<children.size();i++) {
				children.get(i).dfs(array);
			}
			return array;
		}
		
		
	}

}
