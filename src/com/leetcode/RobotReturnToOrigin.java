package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('L', new int[]{-1, 0});
        map.put('R', new int[]{1, 0});

        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            x += map.get(c)[0];
            y += map.get(c)[1];
        }
        return x == 0 && y == 0;
    }

    // Thinking in clever way ( leetcode solution )
    public boolean judgeCircleII(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
