package com.example.p1_100;

import java.util.HashMap;

/**
 * @author zhangyi
 * @date 2023-07-18 16:09
 */
public class P20 {
    public static void main(String[] args) {
        System.out.println(new P20().isValid(
                "(){}}{"
        ));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     *
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     *
     *
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     *
     *
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        HashMap<Character, Character> preSymbolMapping = new HashMap<>();
        preSymbolMapping.put(']', '[');
        preSymbolMapping.put('}', '{');
        preSymbolMapping.put(')', '(');
        StringBuilder builder = new StringBuilder();
        builder.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (preSymbolMapping.containsKey(symbol)) {
                if (builder.length() == 0) {
                    return false;
                }
                Character preSymbol = preSymbolMapping.get(symbol);
                if (builder.charAt(builder.length() - 1) == preSymbol) {
                    builder.deleteCharAt(builder.length() - 1);
                } else {
                    return false;
                }
            } else {
                //不是右符号添加入 builder
                builder.append(symbol);
            }
        }
        return builder.length() == 0;
    }
}
/*
{({}){}}
 */