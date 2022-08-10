package cn.parulpan.code.questionoftheday;

/**
 * 1413. 逐步求和得到正数的最小值
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 * <p>
 * data structure: 数组
 * algorithm: 前缀和 贪心
 *
 * @author parzulpan
 * @since 2022/08/09
 */
public class Solution1413 {
    public static void main(String[] args) {
        System.out.println(new Solution1413().minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(new Solution1413().minStartValue(new int[]{1, 2}));
        System.out.println(new Solution1413().minStartValue(new int[]{1, -2, -3}));
    }

    /**
     * 因为需要累加和 满足 sum + startValue >= 1, 那么需要累加和最小值 sumMin 满足 sumMin + startValue > = 1,
     * 那么 startValue 的最小值就是 1 - sumMin
     */
    public int minStartValue(int[] nums) {
        int sum = 0, sumMin = 0;
        for (int num : nums) {
            sum += num;
            sumMin = Math.min(sum, sumMin);
        }

        return 1 - sumMin;
    }
}
