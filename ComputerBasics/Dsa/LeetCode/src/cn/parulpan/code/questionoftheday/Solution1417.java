package cn.parulpan.code.questionoftheday;

import java.util.ArrayList;

/**
 * 1417. 重新格式化字符串
 * https://leetcode.cn/problems/reformat-the-string/
 * <p>
 * data structure: 字符串
 * algorithm: 模拟
 *
 * @author parzulpan
 * @since 2022/08/11
 */
public class Solution1417 {
    public static void main(String[] args) {
        System.out.println(new Solution1417().reformat("a0b1c2"));
        System.out.println(new Solution1417().reformat("leetcode"));
        System.out.println(new Solution1417().reformat("1229857369"));
        System.out.println(new Solution1417().reformat("covid2019"));
        System.out.println(new Solution1417().reformat("ab123"));
    }

    public String reformat(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        ArrayList<Character> digitList = new ArrayList<>();
        int digitListLength = 0;
        ArrayList<Character> letterList = new ArrayList<>();
        int letterListLength = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                digitList.add(c);
                digitListLength++;
            } else {
                letterList.add(c);
                letterListLength++;
            }
        }

        if (Math.abs(digitListLength - letterListLength) >= 2) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        if (digitListLength > letterListLength) {
            int i;
            for (i = 0; i < letterListLength; i++) {
                ans.append(digitList.get(i));
                ans.append(letterList.get(i));
            }
            if (digitListLength != i) {
                ans.append(digitList.get(digitListLength - 1));
            }
        } else {
            int j;
            for (j = 0; j < digitListLength; j++) {
                ans.append(letterList.get(j));
                ans.append(digitList.get(j));
            }
            if (letterListLength != j) {
                ans.append(letterList.get(letterListLength - 1));
            }
        }

        return ans.toString();
    }
}
