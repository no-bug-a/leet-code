package com.example.p201_300;

/**
 * @author zhangyi
 * @date 2022-12-02 14:14
 */
public class P278 {
    public static void main(String[] args) {
        System.out.println(new P278().firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        return search(1, n, n);
    }
    private int search(int startIndex, int endIndex, int min) {
        int mindIndex = (endIndex - startIndex) / 2 + startIndex;
        if (isBadVersion(mindIndex)) {
            //左
            min = Math.min(min, mindIndex);
            if (startIndex == mindIndex) {
                return min;
            }
            return search(startIndex, mindIndex - 1, min);
        } else {
            //右
            if (mindIndex == endIndex) {
                return min;
            }
            return search(mindIndex + 1, endIndex, min);
        }
    }
    private boolean isBadVersion(int n) {
        return n >= 4;
    }
}
