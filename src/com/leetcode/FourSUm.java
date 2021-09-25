package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSUm {
    // The four sum from algo expert (n2) will not work, because of duplicates. so this solution is inspired by 3 sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < len - 2; j++) {
                int k = j + 1, l = len - 1;
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (k < l) {
                    int cur = nums[i] + nums[j] + nums[k] + nums[l];
                    if (cur == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;

                    } else if (cur > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
