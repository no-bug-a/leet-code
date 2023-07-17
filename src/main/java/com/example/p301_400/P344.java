package com.example.p301_400;

/**
 * @author zhangyi
 * @date 2022-12-12 17:05
 */
public class P344 {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new P344().reverseString(chars);
        System.out.println(chars);
    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     */
    public void reverseString(char[] s) {
        if (s.length == 0 || s.length == 1) return;
        int beginIndex = 0, endIndex = s.length - 1;
        while (beginIndex < endIndex) {
            char t = s[beginIndex];
            s[beginIndex] = s[endIndex];
            s[endIndex] = t;
            beginIndex++;
            endIndex--;
        }
    }
}
