package cn.parulpan.code.questionoftheday;

import java.util.Arrays;

/**
 * 821. 字符的最短距离
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 * <p>
 * data structure: Array, String
 * algorithm: Two Pointers
 *
 * @author parzulpan
 * @since 2022/04/19
 */
public class Solution821 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';

//        String s = "aaab";
//        char c = 'b';

        System.out.println(Arrays.toString(new Solution821().shortestToChar(s, c)));
    }

    public int[] shortestToChar(String s, char c) {
        int[] ret = new int[s.length()];

        int pointer1 = 0;
        int pointer2 = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (i == pointer1) {
                while (s.charAt(pointer1) != c) {
                    pointer1++;
                }
                pointer2 = pointer1;
                if (i != 0) {
                    pointer1 = i;
                }
            }

            ret[i] = Math.min(i - pointer1, pointer2 - i);
        }

        return ret;
    }
}
