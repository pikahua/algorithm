package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    static Map<Character, Integer> map = new HashMap();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length() - 1; i++){
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                num -= map.get(s.charAt(i));
            } else {
                num += map.get(s.charAt(i));
            }
        }
        num += map.get(s.charAt(s.length() -1));
        return num;
    }
}
