package cn.parzulpan.code.chapter02;

import java.util.Objects;

/**
 * 125.验证回文串
 *
 * @author parzulpan
 * @since 2022/5/3
 */
public class Solution125 {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a ca";
        System.out.println(new Solution125().isPalindrome2(s));
    }

    /**
     * 遍历 Reverse
     */
    public boolean isPalindrome(String s) {
        int length = s.length();

        if (length == 0 || length == 1) {
            return true;
        }

        StringBuffer origin = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                origin.append(Character.toLowerCase(c));
            }
        }

        StringBuffer target = new StringBuffer(origin).reverse();

        return Objects.equals(origin.toString(), target.toString());
    }

    /**
     * 正则 Reverse
     */
    public boolean isPalindrome1(String s) {
        String s1 = s.replaceAll("[^A-Za-z0-9]", "");
        String s2 = new StringBuffer(s1).reverse().toString();

        return s1.equalsIgnoreCase(s2);
    }

    /**
     * Double Point
     */
    public boolean isPalindrome2(String s) {
        int length = s.length();

        int left = 0, right = length - 1;
        char head, tail;
        while (left < right) {
            head = s.charAt(left);
            tail = s.charAt(right);
            if (!Character.isLetterOrDigit(head)) {
                ++left;
            } else if (!Character.isLetterOrDigit(tail)) {
                --right;
            }
            else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                ++left;
                --right;
            }
        }

        return true;
    }
}
