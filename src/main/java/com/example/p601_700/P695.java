package com.example.p601_700;

/**
 * @author zhangyi
 * @date 2022-12-13 14:44
 */
public class P695 {
    public static void main(String[] args) {
        System.out.println(new P695().maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }

    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid 。
     *
     * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     *
     * 岛屿的面积是岛上值为 1 的单元格的数目。
     *
     * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 输出：6
     * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
     * 示例 2：
     *
     * 输入：grid = [[0,0,0,0,0,0,0,0]]
     * 输出：0
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 50
     * grid[i][j] 为 0 或 1
     */
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!flags[i][j] && grid[i][j] == 1) {
                    int[] tmp = new int[1];
                    calc(grid, flags, i, j, tmp);
                    max = Math.max(max, tmp[0]);
                }
            }
        }
        return max;
    }

    private void calc(int[][] grid, boolean[][] flags, int sr, int sc, int[] tmp) {
        flags[sr][sc] = true;
        tmp[0]++;
        //上
        if (sr - 1 >= 0 && !flags[sr - 1][sc] && grid[sr - 1][sc] == 1) {
            calc(grid, flags, sr - 1, sc, tmp);
        }
        //下
        if (sr + 1 < grid.length && !flags[sr + 1][sc] && grid[sr + 1][sc] == 1) {
            calc(grid, flags, sr + 1, sc, tmp);
        }
        //左
        if (sc - 1 >= 0 && !flags[sr][sc - 1] && grid[sr][sc - 1] == 1) {
            calc(grid, flags, sr, sc - 1, tmp);
        }
        //右
        if (sc + 1 < grid[0].length && !flags[sr][sc + 1] && grid[sr][sc + 1] == 1) {
            calc(grid, flags, sr, sc + 1, tmp);
        }
    }
}
