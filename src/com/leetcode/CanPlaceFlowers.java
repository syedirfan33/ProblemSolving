package com.leetcode;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && canPick(i, flowerbed)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) return true;
            }
        }
        return false;
    }

    private boolean canPick(int idx, int[] f) {
        int prev = idx == 0 ? 0 : f[idx - 1];
        int next = idx == f.length - 1 ? 0 : f[idx + 1];
        return prev == 0 && next == 0;
    }
}
