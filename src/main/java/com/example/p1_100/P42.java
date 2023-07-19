package com.example.p1_100;

/**
 * @author zhangyi
 * @date 2023-07-19 09:58
 */
public class P42 {

    public static void main(String[] args) {
        System.out.println(new P42().trap(new int[]{
                4,2,0,3,2,5
        }));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *
     * 示例 1：
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     *
     *
     *
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int area = 0;
        int leftIndex = 0;
        int leftHeight = height[leftIndex];
        int rightIndex = height.length - 1;
        int rightHeight = height[rightIndex];
        while (leftIndex < rightIndex) {
            if (leftHeight <= rightHeight) {
                leftIndex++;
                if (height[leftIndex] > leftHeight) {
                    leftHeight = height[leftIndex];
                } else if (height[leftIndex] < leftHeight){
                    area += leftHeight - height[leftIndex];
                }
            } else {
                rightIndex--;
                if (height[rightIndex] > rightHeight) {
                    rightHeight = height[rightIndex];
                } else if (height[rightIndex] < rightHeight){
                    area += rightHeight - height[rightIndex];
                }
            }
        }
        return area;
    }
}
