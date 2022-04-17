package cn.parulpan.code.questionoftheday;

import cn.parulpan.code.utils.LcUtils;

import java.util.*;

/**
 * 819.最常见的单词
 * https://leetcode-cn.com/problems/most-common-word/
 *
 * @author parzulpan
 * @since 2022/4/17
 */
public class Solution819 {
    public static void main(String[] args) {
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};

//        String paragraph = "a.";
//        String[] banned = {};

//        String paragraph = "Bob. hIt, baLl";
//        String[] banned = {"bob", "hit"};

        String paragraph ="a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};

        String result = mostCommonWord(paragraph, banned);

        System.out.println(result);
    }

    /**
     * 注意使用 Character.isLetter 判断单词, 另外最后一个单词要比较
     * 假设 n 是段落 paragraph 的长度, m 是禁用单词列表 banned 的长度, 则 时间和空间复杂度为 O(n+m)
     */
    public static String mostCommonWord(String paragraph, String[] banned) {
        int length = paragraph.length();
        Set<String> set = LcUtils.convert(banned);
        HashMap<String, Integer> map = new HashMap<>(length);

        int maxCount = 0;
        String result = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i <= length; ++i) {
            // 最后一个单词要比较
            if (i < length && Character.isLetter(paragraph.charAt(i))) {
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if (sb.length() > 0){
                String word = sb.toString();
                if (!set.contains(word)) {
                    int count = map.getOrDefault(word, 0) + 1;
                    map.put(word, count);

                    if (count > maxCount) {
                        maxCount = count;
                        result = word;
                    }
                }
                sb.setLength(0);
            }
        }

        return result;
    }
}
