package com.example.p1901_2000;

/**
 * @author zhangyi
 * @date 2023-07-14 16:53
 */
public class P1911 {

    public static void main(String[] args) {
        System.out.println(new P1911().maxAlternatingSum(new int[]{
                6,2,1,2,4,5
        }));
    }

    /**
     * 一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之 和 减去 奇数 下标处元素之 和 。
     *
     * 比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。
     * 给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。
     *
     * 一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的一个子序列（加粗元素），但是 [2,4,2] 不是。
     *
     * 示例 1：
     * 输入：nums = [4,2,5,3]
     * 输出：7
     * 解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
     *
     * 示例 2：
     * 输入：nums = [5,6,7,8]
     * 输出：8
     * 解释：最优子序列为 [8] ，交替和为 8 。
     *
     * 示例 3：
     * 输入：nums = [6,2,1,2,4,5]
     * 输出：10
     * 解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
     */
    public long maxAlternatingSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0L;
        int[] result = new int[nums.length];
        int notAddedMin = Integer.MAX_VALUE;
        int lastIndex = 0;
        for (int num : nums) {
            if (notAddedMin != Integer.MAX_VALUE) {
                if (num > notAddedMin) {
                    result[++lastIndex] = notAddedMin;
                    notAddedMin = Integer.MAX_VALUE;
                    result[++lastIndex] = num;
                } else {
                    notAddedMin = num;
                }
            } else {
                if (num > result[lastIndex]) {
                    result[lastIndex] = num;
                } else {
                    notAddedMin = num;
                }
            }
        }
        long sum = 0L;
        for (int i = 0; i <= lastIndex; i++) {
            if (i % 2 == 0) {
                sum += result[i];
            } else {
                sum -= result[i];
            }
        }
        return sum;
    }
}

/*
时间复杂度O(n)，空间复杂度O(n)
子序列是由原始序列中的一些元素按照它们在原始序列中的出现顺序组成的新序列。由题意可知子序列的交替和最大时元素个数必定为奇数。
整体思想：
遍历数组。
分两种情况：
1、如果当前未添加的min未设置（即为Integer.MAX_VALUE），若当前值大于子序列的尾数则覆盖尾数，否则当前值赋值于未添加的min。
2、如果当前未添加的min已设置，若当前值大于未添加的min则子序列加上未添加的min和当前值，否则当前值赋值于未添加的min。
[6, 2, 1, 2, 4, 3, 10]
步骤拆解
[] max = 0 = []; 未添加的min = Integer.MAX_VALUE; 尾数 = 0;
[6] max = 6 = [6]; 未添加的min = Integer.MAX_VALUE; 尾数 = 6;
[6, 2] max = 6 = [6]; 未添加的min = 2; 尾数 = 6;
[6, 2, 1] max = 6 = [6]; 未添加的min = 1; 尾数 = 6;
[6, 2, 1, 2] max = 7 = [6, 1, 2]; 未添加的min = Integer.MAX_VALUE; 尾数 = 2;
[6, 2, 1, 2, 4] max = 9 = [6, 1, 4]; 未添加的min = Integer.MAX_VALUE; 尾数 = 4;
[6, 2, 1, 2, 4, 3] max = 9 = [6, 1, 4]; 未添加的min = 3; 尾数 = 4;
[6, 2, 1, 2, 4, 3, 10] max = 16 = [6, 1, 4, 3, 10]; 未添加的min = Integer.MAX_VALUE; 尾数 = 10;
 */
