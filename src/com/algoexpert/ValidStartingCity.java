package com.algoexpert;

public class ValidStartingCity {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int n = distances.length;
        int[] res = new int[n];
        int prevMin = 0;
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            int fuelPlus = mpg * fuel[i - 1];
            int disCovered = distances[i - 1];
            int surPlusFuel = res[i - 1];
            res[i] = fuelPlus - disCovered + surPlusFuel; // Note that instead of res array we can simply use res variable to improve efficiency
            if (res[i] < prevMin) {
                minIdx = i;
                prevMin = res[i];
            }
        }
        return minIdx;
    }
}
