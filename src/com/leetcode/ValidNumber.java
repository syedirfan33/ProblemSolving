package com.leetcode;

public class ValidNumber {
    // Coding decoded
    public boolean isNumber(String s) {
        boolean decimalFound = false;
        boolean numberFound = false;
        boolean exponentFound = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '.':
                    if (decimalFound || exponentFound)
                        return false;
                    decimalFound = true;
                    break;
                case '+':
                case '-':
                    if (i != 0 && s.charAt(i - 1) != 'e')
                        return false;
                    numberFound = false;
                    break;
                case 'E':
                case 'e':
                    if (exponentFound || !numberFound)
                        return false;
                    numberFound = false;
                    exponentFound = true;
                    break;
                default:
                    if (!Character.isDigit(c))
                        return false;
                    numberFound = true;
            }
        }
        return numberFound;
    }
}
