package org.example;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int[] longer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            longer[i] = 0;
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                longer[i]++;
            }
        }
        int max = longer[0];
        for (int i = 1; i < longer.length; i++) {
            max = Math.max(max, longer[i]);
        }
        return max;
    }
}
