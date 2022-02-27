package org.example.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                if(s.charAt(i) != map.get(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
