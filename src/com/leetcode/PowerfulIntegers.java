package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    // See other solution too
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        int powX = 1;
        int powY = 1;
        for (int i = 0; powX < bound; i++) {
            for (int j = 0; powY < bound; j++) {
                if (powX + powY <= bound) {
                    set.add(powX + powY);
                } else {
                    break;
                }
                powY = (int) Math.pow(y, j + 1);
                if (powY == 1) break;
            }

            powX = (int) Math.pow(x, i + 1);
            powY = 1;
            if (powX == 1) break;
        }
        return new ArrayList<>(set);
    }

    // clean and easy solution , based on coding decoded video
    public List<Integer> powerfulIntegersII(int x, int y, int bound) {

        Set<Integer> res = new HashSet<>();
        for (int powX = 1; powX < bound; powX = powX * x) {
            for (int powY = 1; powY < bound; powY = powY * y) {
                int cur = powX + powY;
                if (cur <= bound)
                    res.add(cur);
                else
                    break;
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(res);
    }
}
