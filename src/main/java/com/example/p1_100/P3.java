package com.example.p1_100;

/**
 * @author zhangyi
 * @date 2022-12-12 19:56
 */
public class P3 {
    public static void main(String[] args) {
        System.out.println(new P3().lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int beginIndex = 0, endIndex = 1;
        int max = 0;
        while (endIndex < s.length()) {
            if (isDuplicate(s, beginIndex, endIndex)) {
                max = Math.max(endIndex - beginIndex, max);
                beginIndex++;
                continue;
            } else {
                if (endIndex == s.length() - 1) {
                    max = Math.max(endIndex - beginIndex + 1, max);
                }
            }
            endIndex++;
        }
        return max;
    }

    private boolean isDuplicate(String s, int beginIndex, int endIndex) {
        for (int i = beginIndex; i < endIndex; i++) {
            if (s.charAt(i) == s.charAt(endIndex)) {
                return true;
            }
        }
        return false;
    }
}
