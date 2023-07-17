package com.example.p1_100;

/**
 * @author zhangyi
 * @date 2022-12-02 14:55
 */
public class P35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
        System.out.println(new P35().searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= nums.length || startIndex > endIndex) {
            return Math.max(startIndex, endIndex);
        }
        int mindIndex = (endIndex - startIndex) / 2 + startIndex;
        if (nums[mindIndex] == target) {
            return mindIndex;
        } else{

            if (nums[mindIndex] < target) {
                //右边区域
                return searchInsert(nums, target, mindIndex + 1, endIndex);
            } else {
                //左边区域
                return searchInsert(nums, target, startIndex, mindIndex - 1);
            }
        }
    }
}
