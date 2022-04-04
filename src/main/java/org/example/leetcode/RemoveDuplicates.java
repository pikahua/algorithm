package org.example.leetcode;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
//        // 太蠢了，用快慢指针
//        if (nums.length == 0) {
//            return 0;
//        } else if (nums.length == 1) {
//            return 1;
//        }
//        int length = 1;
//        for (int i = 0; i < nums.length; i++) {
//            int end = 1;
//            for (int j = i + 1; j < nums.length; j++) {
//                end = j;
//                if (nums[i] < nums[j]) {
//                    nums[i + 1] = nums[j];
//                    length = i + 2;
//                    break;
//                }
//            }
//            if (end == nums.length - 1) {
//                break;
//            }
//        }
//        return length;
        int n = nums.length;
        if (n == 0) {
            return n;
        }
        int fast = 1;
        int slow = 1;
        while (fast < n) {
            // 这个判断是关键，数组是升序的，遇到不同的数就是要存下来的数
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
