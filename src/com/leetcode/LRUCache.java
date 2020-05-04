/**
 * 
 */
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Irfan
 *
 */
public class LRUCache {

	Map<Integer, Node> node_map;
    int cache_capacity;
    final Node head = new Node();
    final Node tail = new Node();
    
    public LRUCache(int capacity) {
        node_map = new HashMap<>(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = node_map.get(key);
        int result = -1;
        if(node != null){
            result = node.val;
            removeNode(node);
            addNode(node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        Node node = node_map.get(key);
        if(node!=null){
            removeNode(node);
            node.val = value;
            addNode(node);
        }else{
            if(cache_capacity == node_map.size()){
                node_map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
             Node new_node = new Node();
             new_node.key = key;
             new_node.val = value;
             addNode(new_node);
             node_map.put(key, new_node);
        }
    }
    
    public void addNode(Node node){
        if(node!=null){
            Node head_next = head.next;
            head.next = node;
            node.prev = head;
            node.next = head_next;
            head_next.prev = node;
        }
    }
    
    public void removeNode(Node node){
        if(node != null){
            Node node_prev = node.prev;
            Node node_next = node.next;
            node_next.prev = node_prev;
            node_prev.next = node_next;
            
        }
    }
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
