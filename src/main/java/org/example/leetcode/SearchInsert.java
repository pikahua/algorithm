package org.example.leetcode;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        int middle = (left + right)/2;// 溢出
//        while (left <= right) {
//            middle = (left + right)/2;
//            if(nums[middle] == target){
//                return middle;
//            }else if(nums[middle] < target){
//                left = middle + 1;
//            }else if(nums[middle] > target){
//                right = middle - 1;
//            }
//        }
//        if(nums[middle] > target){
//            return middle;
//        }else{
//            return middle + 1;
//        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
