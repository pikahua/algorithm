package org.example.leetcode;

public class StrStr {
    public int strStr(String haystack, String needle) {
//        // 暴力破解
//        if(needle.length() == 0){
//            return 0;
//        }
//        if(needle.length() > haystack.length()){
//            return -1;
//        }
//        int result = 0;
//        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
//            int x = i;
//            int j = 0;
//            for(; j < needle.length(); ){
//                if(needle.charAt(j) == haystack.charAt(x)){
//                    x++;
//                    j++;
//                }else{
//                    break;
//                }
//            }
//            if (j == needle.length()){
//                return i;
//            }
//        }
//        return -1;

        // 优化版本暴力破解
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
