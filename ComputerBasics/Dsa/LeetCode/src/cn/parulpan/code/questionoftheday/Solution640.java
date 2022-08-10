package cn.parulpan.code.questionoftheday;

/**
 * 640. 求解方程
 * https://leetcode.cn/problems/solve-the-equation/
 * <p>
 * data structure: 字符串
 * algorithm: 数学 模拟
 *
 * @author parzulpan
 * @since 2022/08/10
 */
public class Solution640 {
    public static void main(String[] args) {
        System.out.println(new Solution640().solveEquation("x+5-3+x=6+x-2"));
        System.out.println(new Solution640().solveEquation("x=x"));
        System.out.println(new Solution640().solveEquation("2x=x"));
    }

    /**
     * 先按 “=” 分割为左右两边, 然后把 "-" 替换成 "+-", 然后再按 "+" 分割, 最后再移项和合并同类项即可, 注意 "x" 和 "-x" 的特殊处理
     */
    public String solveEquation(String equation) {
        // 把 x 移到左边, 把其他移到右边
        String[] arr = equation.split("=");
        int left = 0, right = 0;
        String[] arrL = arr[0].replace("-", "+-").split("\\+");
        String[] arrR = arr[1].replace("-", "+-").split("\\+");

        // 等式左边处理
        for (String s : arrL) {
            if ("x".equals(s)) {
                left += 1;
            } else if ("-x".equals(s)) {
                left += -1;
            } else if (s.contains("x")) {
                left += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!"".equals(s)) {
                right -= Integer.parseInt(s);
            }
        }

        // 等式右边处理
        for (String s : arrR) {
            if ("x".equals(s)) {
                left -= 1;
            } else if ("-x".equals(s)) {
                left -= -1;
            } else if (s.contains("x")) {
                left -= Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!"".equals(s)) {
                right += Integer.parseInt(s);
            }
        }

        // 结果处理
        if (left == 0) {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + right / left;
        }
    }
}
