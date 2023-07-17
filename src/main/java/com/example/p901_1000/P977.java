package com.example.p901_1000;

/**
 * @author zhangyi
 * @date 2022-12-05 19:11
 */
public class P977 {
    public static void main(String[] args) {
        for (int i : new P977().sortedSquares(new int[]{-4,-1,0,1,10})) {
            System.out.print(i + " ");
        }
    }

    public int[] sortedSquares(int[] nums) {
        if (nums == null) return null;
        int[] arr = new int[nums.length];
        int negativeIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                negativeIndex = i - 1;
                break;
            }
            nums[i] *= nums[i];
        }
        int positiveIndex = negativeIndex + 1;
        for (int i = positiveIndex; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        int i = 0;
        while (negativeIndex >= 0 || positiveIndex < nums.length) {
            if (negativeIndex < 0) {
                arr[i++] = nums[positiveIndex++];
                continue;
            }
            if (positiveIndex >= nums.length) {
                arr[i++] = nums[negativeIndex--];
                continue;
            }
            if (nums[positiveIndex] > nums[negativeIndex]) {
                arr[i++] = nums[negativeIndex--];
            } else {
                arr[i++] = nums[positiveIndex++];
            }
        }
        return arr;
    }
}
