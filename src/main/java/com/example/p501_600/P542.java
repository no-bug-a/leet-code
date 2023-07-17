package com.example.p501_600;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangyi
 * @date 2022-12-13 19:26
 */
public class P542 {
    public static void main(String[] args) {
        for (int[] ints : new P542().updateMatrix(new int[][]{
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}})) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }

            System.out.println();
        }
    }

    /**
     * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     *
     * 两个相邻元素间的距离为 1 。
     *
     * 示例 1：
     *
     * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：[[0,0,0],[0,1,0],[0,0,0]]
     * 示例 2：
     *
     * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
     * 输出：[[0,0,0],[0,1,0],[1,2,1]]
     *
     * 提示：
     *
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 104
     * 1 <= m * n <= 104
     * mat[i][j] is either 0 or 1.
     * mat 中至少有一个 0
     */
    public int[][] updateMatrix(int[][] mat) {
        Point[][] points = new Point[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                calcMatrix(mat, points, i, j);
            }
        }
        return mat;
    }

    private void calcMatrix(int[][] mat, Point[][] points, int i, int j) {
        if (mat[i][j] == 0) {
            points[i][j] = new Point(i, j);
            return;
        }
        boolean[][] flags = new boolean[mat.length][mat[0].length];
        mat[i][j] = Integer.MAX_VALUE;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            flags[point.x][point.y] = true;
            if (mat[point.x][point.y] == 0) {
                mat[i][j] = Math.min(Math.abs(point.x - i) + Math.abs(point.y - j), mat[i][j]);
                return;
            }
            //上
            if (point.x - 1 >= 0 && !flags[point.x - 1][point.y]) {
                queue.offer(new Point(point.x - 1, point.y));
            }
            //下
            if (point.x + 1 < mat.length && !flags[point.x + 1][point.y]) {
                queue.offer(new Point(point.x + 1, point.y));
            }
            //左
            if (point.y - 1 >= 0 && !flags[point.x][point.y - 1]) {
                queue.offer(new Point(point.x, point.y - 1));
            }
            //右
            if (point.y + 1 < mat[0].length && !flags[point.x][point.y + 1]) {
                queue.offer(new Point(point.x, point.y + 1));
            }
        }
    }

}
/**

 1 1 1 0 1 1 0 1 1 1 1 1
 0 0 0 0 0 0 0 0 0 0 0 0
 1 1 1 1 1 1 1 1 1 1 1 1
 0 0 0 0 0 0 0 0 0 0 0 0
 1 1 1 1 1 1 1 1 1 1 1 1


 */