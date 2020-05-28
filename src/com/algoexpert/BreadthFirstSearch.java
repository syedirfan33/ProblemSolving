package com.algoexpert;

/**
 * @author Syed Irfan - 25/05/2020
 */
import java.util.*;

class BredthFirstSearch {
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();
        
        public Node(String name) {
            this.name = name;
        }
        
        public List<String> breadthFirstSearch(List<String> array) {
            List<String> res = new ArrayList<>();
            Queue<Node> queue= new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                res.add(cur.name);
                queue.addAll(cur.children);
            }
            return res;
        }
        
        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}

