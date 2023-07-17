package com.example.p201_300;

/**
 * @author zhangyi
 * @date 2023-07-17 16:22
 */
public class P209 {

    public static void main(String[] args) {
        System.out.println(new P209().minSubArrayLen(4, new int[]{
                1,4,4
        }));
    }

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     *
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     *
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     */
    public int minSubArrayLen(int target, int[] nums) {
        int[] results = new int[nums.length];
        results[0] = 1;
        int index = 0;
        int sum = nums[0];
        int min = Integer.MAX_VALUE;
        if (sum >= target) return 1;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            results[i] = results[i - 1] + 1;
            if (sum >= target) {
                for (int j = index; j < i; j++) {
                    if (sum - nums[j] < target) {
                        break;
                    }
                    sum -= nums[j];
                    index = j + 1;
                    results[i] --;
                }
                min = Math.min(results[i], min);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
