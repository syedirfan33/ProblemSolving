/**
 *
 */
package com.algoexpert;

import com.algoexpert.FindLoop.LinkedList;

/**
 * @author Syed Irfan
 *
 */
public class ReverseLL {


    public static LinkedList reverse(LinkedList head) {
        LinkedList prev = null, cur = head;
        while (cur != null) {
            LinkedList next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        LinkedList(int value) {
            this.value = value;
        }
    }
}
