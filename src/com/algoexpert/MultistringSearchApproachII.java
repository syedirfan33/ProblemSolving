package com.algoexpert;

import java.util.*;

public class MultistringSearchApproachII {
    // Approach 1
    // If we construct trie for bigger string, TC will be O(B2 + SN)
    // Where B is len of bigger str, S is len of smaller str(maximum entry) and N is total no. of smaller strings
    // Note that no need to include end symbol here, like we did for suffix trie. because we are not searching for suffixes

    // Approach 2
    // But if we construct trie for smaller string, TC will be O(SN + BS) and this is optimised.
    // BS is because for searching, within B, in worst case B has to search against S chars only. See code to understand

    static class Trie {
        Map<Character, Trie> children = new HashMap<>();
    }


    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        Set<String> resSet = new HashSet<>();
        Trie root = new Trie();
        for (String str : smallStrings) {
            construct(str, root);
        }
        for (int i = 0; i < bigString.length(); i++) {
            search(i, bigString, root, resSet);
        }
        List<Boolean> res = new ArrayList<>();
        for (String str : smallStrings) {
            if (resSet.contains(str)) res.add(true);
            else res.add(false);
        }
        return res;
    }

    private static void construct(String str, Trie root) {
        Trie node = root;
        for (char c : str.toCharArray()) {
            if (!node.children.containsKey(c))
                node.children.put(c, new Trie());

            node = node.children.get(c);
        }
        node.children.put('*', null);
    }

    private static void search(int idx, String bigString, Trie root, Set<String> resSet) {
        Trie node = root;
        for (int i = idx; i < bigString.length(); i++) {
            char c = bigString.charAt(i);
            if (!node.children.containsKey(c)) return;
            node = node.children.get(c);
            if (node.children.containsKey('*')) {
                resSet.add(bigString.substring(idx, i + 1));
            }
        }
    }
}
