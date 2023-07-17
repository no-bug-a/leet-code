package com.example.p101_200;

import java.util.Arrays;

/**
 * @author zhangyi
 * @date 2022-12-05 19:44
 */
public class P189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        for (int i = 0; i < nums.length; i++) {
            int[] tmp = Arrays.copyOf(nums, nums.length);
            new P189().rotate(tmp, i + 1);
            System.out.print("k = " + (i + 1) + " ---> ");
            for (int num : tmp) {
                System.out.print(num + "   ");
            }
            System.out.println();
        }
    }
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int index = 0;
        do {
            nums[(index + k) % nums.length] = copy[index++];
        } while (index < nums.length);
    }
}
