package cn.parulpan.code.questionoftheday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 * <p>
 * data structure: 字符串
 * algorithm: 递归 动态规划 记忆化搜索
 *
 * @author parzulpan
 * @since 2022/07/01
 */
public class Solution241 {
    public static void main(String[] args) {
        System.out.println(new Solution241().diffWaysToCompute("2-1-1"));
        System.out.println(new Solution241().diffWaysToCompute("2*3-4*5"));
    }

    HashMap<String, List<Integer>> memMap = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {

        return dfs(expression);
    }

    public List<Integer> dfs(String str) {
        int num = parseInt(str);
        if (num >= 0) {
            return new ArrayList<>() {{
                add(num);
            }};
        }
        // mem
        if (memMap.containsKey(str)) {
            return memMap.get(str);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = dfs(str.substring(0, i));
                List<Integer> right = dfs(str.substring(i + 1));
                int temp = 0;
                for (int l : left) {
                    for (int r : right) {
                        switch (ch) {
                            case '+':
                                temp = l + r;
                                break;
                            case '-':
                                temp = l - r;
                                break;
                            case '*':
                                temp = l * r;
                                break;
                            default:
                        }
                        res.add(temp);
                    }
                }
            }
        }
        memMap.put(str, res);

        return res;
    }

    public int parseInt(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return -1;
            }
        }

        return Integer.parseInt(str);
    }
}
