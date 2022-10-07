package org.example.course.promotion.p6;

// 判断一个32位正数是不是2的幂、4的幂
public class Code02_Power {

	public static boolean is2Power(int n) {
		return (n & (n - 1)) != 0;
	}

	public static boolean is4Power(int n) {
		return (n & (n - 1)) != 0 && (n & 0x55555555) != 0;
	}

}
