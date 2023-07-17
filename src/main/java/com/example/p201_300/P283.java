package com.example.p201_300;

/**
 * @author zhangyi
 * @date 2022-12-12 10:27
 */
public class P283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 2, 0, 2, 3, 4, 0, 0, 2};
        new P283().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + "   ");
        }
        System.out.println();
    }
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (offset != 0) {
                if (nums[i] != 0) {
                    //开始移动
                    i = moveZeroes(nums, i, offset);
                    offset = 0;
                }
            }
            if (nums[i] == 0) {
                offset++;
            }
        }
    }

    private int moveZeroes(int[] nums, int begin, int offset) {
        //查询下一个为0的数
        int end = begin;
        for (int i = end + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                break;
            }
            end++;
        }
        if (end + 1 - begin >= 0) System.arraycopy(nums, begin, nums, begin - offset, end + 1 - begin);
        for (int i = end - offset + 1; i <= end; i++) {
            nums[i] = 0;
        }
        return end - offset + 1;
    }
}
// 0 0 1 2 0 2 3 4 0 0 2

// 1 2 0 0 0 2 3 4 0 0 2

// 1 2 2 3 4 0 0 0 0 0 2

// 1 2 2 3 4 2 0 0 0 0 0



// 0 1 2 0 2 3 4 0 0 2
// 1 2 0 0 2 3 4 0 0 2
// 1 2 2 3 4 0 0 0 0 2