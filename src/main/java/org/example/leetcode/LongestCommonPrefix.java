package org.example.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder pre = new StringBuilder("");
        int minLength = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if(minLength > strs[i].length()){
                minLength = strs[i].length();
            }
        }
        if(minLength == 0){
            return pre.toString();
        }
        for (int i = 0; i < minLength; i++) {
            for (int j = 1; j < strs.length; j++) {
                if(strs[0].charAt(i) != (strs[j].charAt(i))){
                    return pre.toString();
                }
            }
            pre.append(strs[0].charAt(i));
        }
        return pre.toString();
    }
}
