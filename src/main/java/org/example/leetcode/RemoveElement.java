package org.example.leetcode;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while(fast < n){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
