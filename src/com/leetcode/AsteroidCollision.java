package com.leetcode;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < asteroids.length) {
            if (asteroids[i] > 0)
                stack.push(asteroids[i]);
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }
            }
            i++; // could use for loop too.
        }
        int[] res = new int[stack.size()];
        for (int j = res.length - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return res;
    }
}
