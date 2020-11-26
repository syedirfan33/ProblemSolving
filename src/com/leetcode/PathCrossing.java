package com.leetcode;

import java.util.*;

public class PathCrossing {
    class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object other) {
            Coordinate otherObj = (Coordinate) other;
            return this.x == otherObj.x && this.y == otherObj.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    public boolean isPathCrossing(String path) {
        Map<Character, Coordinate> map = new HashMap<>();
        map.put('N', new Coordinate(1, 0));
        map.put('S', new Coordinate(-1, 0));
        map.put('E', new Coordinate(0, 1));
        map.put('W', new Coordinate(0, -1));
        Set<Coordinate> set = new HashSet<>(); // or we could use simple string to check equality
        Coordinate cur = new Coordinate(0, 0);
        set.add(cur);
        for (char c : path.toCharArray()) {
            cur.x += map.get(c).x;
            cur.y += map.get(c).y;
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
        }
        return false;
    }
}
