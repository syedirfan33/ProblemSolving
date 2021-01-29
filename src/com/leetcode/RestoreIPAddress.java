package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    // Same as valid ip address Algo expert
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res;
        // i < 4 beacase we support 4 chars max at i
        for(int i = 1; i < 4; i++){
            String s1 = s.substring(0, i);
            if(!isValid(s1)) break;
            // j - i < 4, same reason. We support less than 4 chars only
            // j + 2 should be less than s.length() because we need additional two chars to accomodate other two entried, k and l. Note that less than or equal to is used as we do substring method
            for(int j = i + 1; j - i < 4 && j + 2 <= s.length(); j++){
                String s2 = s.substring(i, j);
                if(!isValid(s2)) break;
                // k + 1 should be less than s.length() because we need additional one char to accomodate l
                for(int k = j + 1; k - j < 4 && k + 1 <= s.length(); k++){
                    String s3 = s.substring(j, k), s4 = s.substring(k); // s4 is last item
                    if(isValid(s3) && isValid(s4))
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s){
        if(s.charAt(0) == '0' && s.length() > 1) return false; // contains leading zeros
        return Integer.parseInt(s) <= 255;
    }
}
