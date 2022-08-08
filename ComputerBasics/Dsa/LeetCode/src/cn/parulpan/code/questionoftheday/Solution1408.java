package cn.parulpan.code.questionoftheday;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 * https://leetcode.cn/problems/string-matching-in-an-array/
 * <p>
 * data structure: 字符串
 * algorithm: 字符串匹配
 *
 * @author parzulpan
 * @since 2022/08/06
 */
public class Solution1408 {
    public static void main(String[] args) {
        System.out.println(new Solution1408().stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(new Solution1408().stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(new Solution1408().stringMatching(new String[]{"blue", "green", "bu"}));
    }

    /**
     * 根据题意暴力模拟即可
     */
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }
}
