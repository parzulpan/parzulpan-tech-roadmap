package cn.parulpan.code.questionoftheday;

import java.util.ArrayList;

/**
 * 761. 特殊的二进制序列
 * https://leetcode.cn/problems/special-binary-string/
 * <p>
 * data structure: 字符串
 * algorithm: 递归
 *
 * @author parzulpan
 * @since 2022/08/08
 */
public class Solution761 {
    public static void main(String[] args) {
        System.out.println(new Solution761().makeLargestSpecial("11011000"));
    }

    /**
     * 我的建议是开摆
     */
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) {
            return s;
        }

        ArrayList<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0, j = 0, k = 0; i < chars.length; i++) {
            k += chars[i] == '1' ? 1 : -1;
            if (k == 0) {
                list.add("1" + makeLargestSpecial(s.substring(j + 1, i)) + "0");
                j = i + 1;
            }
        }
        list.sort((a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String s1 : list) {
            sb.append(s1);
        }

        return sb.toString();
    }
}
