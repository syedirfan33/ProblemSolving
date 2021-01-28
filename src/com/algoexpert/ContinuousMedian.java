package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ContinuousMedian {
    // O(logn) for insert, O(1) to get median
    static class ContinuousMedianHandler {
        List<Integer> list = new ArrayList<>();
        public void insert(int number) {

            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) < number) {
                    left = mid + 1;
                } else if (list.get(mid) > number) {
                    right = mid - 1;
                } else {
                    list.add(mid, number);
                    return;
                }
            }
            list.add(left, number); // in case we never add values
        }

        public double getMedian() {
            int size = list.size();
            if (size % 2 == 0) {
                return (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;
            }
            return list.get(size / 2);
        }
    }
}
