package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackConstruction {
    static class MinMaxStack {

        // Same idea as min stack construction leet code, all operations O(1)
        List<Integer> stack = new ArrayList<>();
        List<Integer> minStack = new ArrayList<>();
        List<Integer> maxStack = new ArrayList<>();
        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            if(minStack.size() > 0 && getMin() == peek()){
                minStack.remove(minStack.size() - 1);
            }
            if(maxStack.size() > 0 && getMax() == peek()){
                maxStack.remove(maxStack.size() - 1);
            }
            int res = peek();
            stack.remove(stack.size() - 1);
            return res;
        }

        public void push(Integer number) {
            if(minStack.size() == 0 || number <= getMin()){
                minStack.add(number);
            }
            if(maxStack.size() == 0 || number >= getMax()){
                maxStack.add(number);
            }
            stack.add(number);
        }

        public int getMin() {
            return minStack.get(minStack.size() - 1);
        }

        public int getMax() {
            return maxStack.get(maxStack.size() - 1);
        }
    }
}
