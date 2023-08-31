package org.example;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.println("cmcmb".substring("cmcmb".length() - 1));
    }

    // 指定长度由c,m组成的字符串，不能连续两个及以上c，组成的个数
    public int validNum (int N) {
        // write code here
        return f1(N, "");
    }

    public int f1(int N, String s) {
        int res = 0;
        if (N == s.length()) {
            return 1;
        }
        if (s.length() == 0) {
            res = f1(N, s + "c") + f1(N, s + "m");
        } else {
            String sub = s.substring(s.length() - 1);
            char c = sub.charAt(0);
            if (c == 'm') {
                res = f1(N, s + "c") + f1(N, s + "m");
            } else {
                res = f1(N, s + "m");
            }
        }
        return res;
    }

    public void f(int N, String s, List<String> list) {
        if (N == s.length()) {
            list.add(s);
        }
        if (s.length() == 0) {
            String s2 = new String(s);
            f(N, s + "c", list);
            f(N, s + "m", list);
        } else {
            String sub = s.substring(s.length() - 1);
            char c = sub.charAt(0);
            if (c == 'm') {
                String s2 = new String(s);
                f(N, s + "c", list);
                f(N, s + "m", list);
            } else {
                f(N, s + "m", list);
            }
        }
    }


    // 按秒分时优先级排序
    public ArrayList<String> timeSort (ArrayList<String> times) {
        // write code here
        PriorityQueue<String> queue = new PriorityQueue<>((n1, n2) -> {
            String[] split1 = n1.split(":");
            String[] split2 = n2.split(":");
            return Integer.parseInt(split1[0]) - Integer.parseInt(split2[0]);
        });
        for (String str : times) {
            queue.offer(str);
        }
        ArrayList<String> list1 = new ArrayList<String>();
        while (!queue.isEmpty()) {
            list1.add(queue.poll());
        }

        PriorityQueue<String> queue2 = new PriorityQueue<>((n1, n2) -> {
            String[] split1 = n1.split(":");
            String[] split2 = n2.split(":");
            return Integer.parseInt(split1[1]) - Integer.parseInt(split2[1]);
        });
        for (String str : list1) {
            queue2.offer(str);
        }
        ArrayList<String> list2 = new ArrayList<String>();
        while (!queue2.isEmpty()) {
            list2.add(queue2.poll());
        }

        PriorityQueue<String> queue3 = new PriorityQueue<>((n1, n2) -> {
            String[] split1 = n1.split(":");
            String[] split2 = n2.split(":");
            return Integer.parseInt(split1[2]) - Integer.parseInt(split2[2]);
        });
        for (String str : list2) {
            queue3.offer(str);
        }
        ArrayList<String> list3 = new ArrayList<String>();
        while (!queue3.isEmpty()) {
            list3.add(queue3.poll());
        }

        return list3;

    }
}
