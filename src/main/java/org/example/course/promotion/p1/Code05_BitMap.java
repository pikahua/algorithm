package org.example.course.promotion.p1;

// 位图
public class Code05_BitMap {
    public static void main(String[] args) {
        //32bit * 10 ->320 bits
        //arr[0] int 0 ~ 31
        //arr[1] int 32~63
        int[] arr = new int[10];
        // 想取得178个bit的状态
        int i = 178;
        int numIndex = i / 32;
        int bitIndex = i % 32;
        // 拿到178位的状态
        int s = ((arr[numIndex] >> (bitIndex)) & 1);
        // 请把178位的状态改成1
        arr[numIndex] = arr[numIndex] | (1 << (bitIndex));
        // 请把178位的状态改成0
        arr[numIndex] = arr[numIndex] & (~(1 << bitIndex));
    }
}
