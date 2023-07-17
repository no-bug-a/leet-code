package com.example.p701_800;

/**
 * @author zhangyi
 * @date 2022-12-02 10:52
 */
public class P704 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,5};
        int target = -2;
        System.out.println(new P704().search(nums, target));
    }
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length -1);
    }

    public int search(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= nums.length || startIndex > endIndex) {
            return -1;
        }
        int mindIndex = (endIndex - startIndex) / 2 + startIndex;
        if (nums[mindIndex] == target) {
            return mindIndex;
        } else{
            if (nums[mindIndex] < target) {
                //右边区域
                return search(nums, target, mindIndex + 1, endIndex);
            } else {
                //左边区域
                return search(nums, target, startIndex, mindIndex - 1);
            }
        }
    }
}
