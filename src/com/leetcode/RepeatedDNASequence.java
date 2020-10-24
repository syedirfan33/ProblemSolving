package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> dnas = new HashSet<String>();
        Set<String> res = new HashSet<String>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String dna = s.substring(i, i + 10);
            if (!dnas.add(dna)) {
                res.add(dna);
            }
        }
        return new ArrayList<>(res);
    }

}
