package com.leetcode;

import java.util.*;

public class MinimumCostOfTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 30 + 1];
        Set<Integer> set = new HashSet<>();
        for (int day : days) set.add(day);
        for (int i = days[days.length - 1]; i >= days[0]; i--) {
            if (!set.contains(i)) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.min(dp[i + 1] + costs[0], dp[i + 7] + costs[1]);
                dp[i] = Math.min(dp[i], dp[i + 30] + costs[2]);
            }
        }
        System.out.println(Arrays.toString(dp)); // See this if you have difficulties in understanding
        return dp[days[0]];
    }

    public int mincostTicketsII(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return minCostTickets(days, costs, 0, dp);
    }

    //Copied solution, but I was definitely going through this approach
    public static int minCostTickets(int[] days, int[] costs, int day, int[] dp){
        if(day >= days.length) return 0;
        //return previously calculated day
        if(dp[day] != 0) return dp[day];
        int i;


        //Attempt to buy a one-day ticket
        int buyOneDay =  minCostTickets(days, costs, day + 1, dp) + costs[0];

        //Attempt to buy a seven-day ticket and skip all days that will be included in this ticket
        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 7) break;
        int buySevenDays = minCostTickets(days, costs, i, dp) + costs[1];

        //Attempt to buy a thirty-day ticket and skip all days that will be included in this ticket
        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 30) break;
        int buyThirtyDays = minCostTickets(days, costs, i, dp) + costs[2];

        //return minimum of three options
        int result = Math.min(Math.min(buyOneDay, buySevenDays), buyThirtyDays);
        dp[day] = result;
        return result;

    }
}
