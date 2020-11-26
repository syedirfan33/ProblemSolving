package com.leetcode;

public class DesignHashMap {
    class Node {
        int key, value;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    /**
     * Initialize your data structure here.
     */
    Node[] buckets;
    int size = 10000;

    public DesignHashMap() {
        buckets = new Node[size];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int idx = getIdx(key);
        Node node = search(idx, key);
        if (node.next == null) {
            Node cur = new Node(key);
            node.next = cur;
        }
        node.next.value = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int idx = getIdx(key);
        Node node = search(idx, key);
        if (node.next == null) return -1;
        return node.next.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int idx = getIdx(key);
        Node node = search(idx, key);
        if (node.next != null) {
            node.next = node.next.next;
        }
    }

    private int getIdx(int key) {
        return key % size;
    }

    private Node search(int idx, int key) {
        if (buckets[idx] == null) {
            buckets[idx] = new Node(-1);
        }
        Node prev = buckets[idx];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
}
