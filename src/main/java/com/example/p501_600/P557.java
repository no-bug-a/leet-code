package com.example.p501_600;

/**
 * @author zhangyi
 * @date 2022-12-12 17:13
 */
public class P557 {
    public static void main(String[] args) {
        System.out.println(new P557().reverseWords("God"));
    }

    /**
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * 示例 2:
     *
     * 输入： s = "God Ding"
     * 输出："doG gniD"
     */
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int nextIndex = s.indexOf(" ");
        int beginIndex = 0;
        while (nextIndex != -1) {
            for (int i = nextIndex - 1; i >= beginIndex; i--) {
                builder.append(s.charAt(i));
            }
            builder.append(" ");
            beginIndex = nextIndex + 1;
            nextIndex = s.indexOf(" ", beginIndex);
        }
        for (int i = s.length() - 1; i >= beginIndex; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
