package org.example.leetcode;

public class isPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }else if(x == 0){
            return true;
        }
        int a = x;
        int y = 0;
        int b;
        while (a > 0){
            b = a % 10;
            a = a / 10;
            y = b + y * 10;
        }
        return x == y ? true : false;
    }
}
