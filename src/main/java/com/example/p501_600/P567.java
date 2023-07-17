package com.example.p501_600;

/**
 * @author zhangyi
 * @date 2022-12-12 20:21
 */
public class P567 {
    public static void main(String[] args) {
        System.out.println(new P567().checkInclusion("ab", "aa"));
    }

    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     *
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     *
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     *
     *
     * 提示：
     *
     * 1 <= s1.length, s2.length <= 104
     * s1 和 s2 仅包含小写字母
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] subCount = new int[26];
        int[] parentCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            subCount[s1.charAt(i) - 97]++;
            parentCount[s2.charAt(i) - 97]++;
        }
        int len = s1.length();
        for (int i = 0; i <= s2.length() - len; i++) {
            if (isContain(subCount, parentCount, s2, i, len)) {
                return true;
            }
            parentCount[s2.charAt(i) - 97]--;
            if (i + len < s2.length()) {
                parentCount[s2.charAt(i + len) - 97]++;
            }
        }
        return false;
    }

    private boolean isContain(int[] subCount, int[] parentCount, String s2, int index, int len) {
        for (int i = 0; i < subCount.length; i++) {
            if (subCount[i] != parentCount[i]) {
                return false;
            }
        }
        return true;
    }
}
