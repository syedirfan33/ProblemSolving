package com.algoexpert;

public class InterweavingStrings {
    // This is my first solution, not so optimizes as I am using substring method additionally
    public static boolean interweavingStrings(String one, String two, String three) {
        if(one.length() + two.length() != three.length()) return false;
        int i = 0;
        int j = 0;
        int k = 0;
        while(k < one.length() + two.length()){
            char first = i < one.length() ? one.charAt(i) : ' ';
            char second = j < two.length() ? two.charAt(j):' ' ;
            char third = three.charAt(k);
            if(first != third && second != third){
                System.out.println(i + " "+j + " "+ k);
                return false;
            }else if(first == third && second == third){
                return interweavingStrings(one.substring(i, one.length()), two.substring(j + 1, two.length())
                        , three.substring(k + 1, three.length())) ||
                        interweavingStrings(one.substring(i + 1, one.length()), two.substring(j, two.length())
                                , three.substring(k + 1, three.length()));
            }else if(second == third){
                j++;
            }else if(first == third){
                i++;
            }
            k++;
        }
        return true;
    }

    // Approach II, without using memo O(2^ (m + n))
    public static boolean interweavingStringsII(String one, String two, String three) {
        if(one.length() + two.length() != three.length()) return false;
        return helper(one, two, three, 0, 0);
    }

    private static boolean helper(String one, String two, String three, int i, int j){
        int k = i + j;
        if(k >= three.length()) return true; // Basecase
        char first = i < one.length() ? one.charAt(i) : ' ';
        char second = j < two.length() ? two.charAt(j):' ' ;
        char third = three.charAt(k);
        if(first != third && second != third){
            return false;
        }else if(first == third && second == third){
            return helper(one, two, three, i + 1, j) || helper(one, two, three, i, j + 1);
        }else if(first == third){
            return helper(one, two, three, i + 1, j);
        }else if(second == third){
            return helper(one, two, three, i, j + 1);
        }
        return true;
    }

    // Approach 3, using memo O(m * n)
    public static boolean interweavingStringsIII(String one, String two, String three) {
        if(one.length() + two.length() != three.length()) return false;
        Boolean[][] memo = new Boolean[one.length() + 1][two.length() + 1]; // + 1 beacause at some point of time, one of the indexes may go out of bound
        return helper(one, two, three, 0, 0, memo);                   // For ex, one = aaaa, two = fbb, three = aaaafbb ( i = 4, j = 0, i + j = 4 )
    }

    private static boolean helper(String one, String two, String three, int i, int j, Boolean[][] memo){
        if(memo[i][j] != null) return memo[i][j];
        int k = i + j;
        if(k >= three.length()) return true; // Base case
        char first = i < one.length() ? one.charAt(i) : ' ';
        char second = j < two.length() ? two.charAt(j):' ' ;
        char third = three.charAt(k);
        boolean res = false;
        if(first != third && second != third){
            res =  false; // Redundant, but still good to understand
        }else if(first == third && second == third){
            res = helper(one, two, three, i + 1, j, memo) || helper(one, two, three, i, j + 1, memo);
        }else if(first == third){
            res = helper(one, two, three, i + 1, j, memo);
        }else if(second == third){
            res = helper(one, two, three, i, j + 1, memo);
        }
        memo[i][j] = res;
        return res;
    }
}
