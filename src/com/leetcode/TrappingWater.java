/**
 *
 */
package com.leetcode;

import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class TrappingWater {

    public static int trap(int[] arr) {
        int n = arr.length;
        int water = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }

        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return water;
    }

    public static void main(String[] args) {
        int[] in = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(in));
    }

    //One pass solution, updating max min realtime
    public int trapII(int[] height) {
        // time : O(n)
        // space : O(1)
        if (height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left];
            if (height[right] > rightMax) rightMax = height[right];
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
