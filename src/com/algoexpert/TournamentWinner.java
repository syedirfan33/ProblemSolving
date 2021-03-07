package com.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> map = new HashMap<>();
        int maxScore = 0;
        String winner = "";
        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> cur = competitions.get(i);
            String home = cur.get(0), away = cur.get(1);
            String curWin = results.get(i) == 1 ? home : away;
            map.put(curWin, map.getOrDefault(curWin, 0) + 3);
            if (map.get(curWin) > maxScore) {
                maxScore = map.get(curWin);
                winner = curWin;
            }
        }
        return winner;
    }
}
