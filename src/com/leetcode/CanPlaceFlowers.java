package com.leetcode;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (canPlace(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
            if (n == 0) return true;
        }
        return false;
    }

    private boolean canPlace(int[] flowered, int i) {
        int prev = i == 0 ? i : i - 1;
        int next = i == flowered.length - 1 ? i : i + 1;
        return flowered[i] == 0 && flowered[prev] == 0 && flowered[next] == 0;
    }
}
