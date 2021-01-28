package com.algoexpert;

public class ShiftLinkedList {
    //Same as rotate list leet code, only change is k can be negative.
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        if (head == null || head.next == null) return head;
        int len = 1;
        LinkedList tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        int offset = Math.abs(k) % len;
        if (offset == 0) return head;
        LinkedList newTail = head;
        int newTailPosi = k > 0 ? len - offset : offset;
        for (int i = 1; i < newTailPosi; i++) {
            newTail = newTail.next;
        }
        LinkedList newHead = newTail.next;
        tail.next = head;
        newTail.next = null;
        return newHead;
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
