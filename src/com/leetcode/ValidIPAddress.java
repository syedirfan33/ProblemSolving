package com.leetcode;

import javax.sound.midi.Soundbank;
import java.util.StringTokenizer;

/**
 * @author Syed Irfan - 17/06/2020
 */
public class ValidIPAddress {
    String NEITHER = "Neither";
    String IPv4 = "IPv4";
    String IPv6 = "IPv6";
    
    public String validIPAddress(String IP) {
        if (IP.chars().filter(c -> '.' == c).count() == 3) {
            StringTokenizer tokens = new StringTokenizer(IP, ".");
            if(tokens.countTokens() != 4) return NEITHER;
            while (tokens.hasMoreTokens()) {
                String cur = tokens.nextToken();
                if (cur.length() == 0 || cur.length() > 3) return NEITHER;
                if (cur.length() != 1 && cur.charAt(0) == '0') return NEITHER;
                for (char c : cur.toCharArray()) {
                    if(!Character.isDigit(c)) return NEITHER;
                }
                if (Integer.parseInt(cur) > 255) return NEITHER;
            }
            return IPv4;
            
        } else if (IP.chars().filter(c -> ':' == c).count() == 7) {
            StringTokenizer tokens = new StringTokenizer(IP, ":");
            if(tokens.countTokens() != 8) return NEITHER;
            while (tokens.hasMoreTokens()) {
                String cur = tokens.nextToken();
                if (cur.length() == 0 || cur.length() > 4) return NEITHER;
                for (char c : cur.toCharArray()) {
                    if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                        return NEITHER;
                    }
                }
            }
            return IPv6;
            
        }
        return NEITHER;
    }
}
