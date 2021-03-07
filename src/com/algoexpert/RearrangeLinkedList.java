package com.algoexpert;

public class RearrangeLinkedList {
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedList smaller = new LinkedList(Integer.MIN_VALUE), equal = new LinkedList(Integer.MIN_VALUE), bigger = new LinkedList(Integer.MIN_VALUE);
        LinkedList smallerHead = smaller, equalHead = equal, biggerHead = bigger;
        while (head != null) {
            if (head.value == k) {
                equal.next = head;
                equal = equal.next;
            } else if (head.value < k) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        // Below order is very important.
        // First set bigger next to be null, as it's gonna be tail
        // the, set equal tail to bigger head and finally set smaller tail to equal head
        bigger.next = null;
        equal.next = biggerHead.next;
        smaller.next = equalHead.next;
        return smallerHead.next;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
