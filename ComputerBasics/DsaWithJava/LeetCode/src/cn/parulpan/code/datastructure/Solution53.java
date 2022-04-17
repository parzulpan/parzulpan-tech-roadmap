package cn.parulpan.code.datastructure;

import java.util.Objects;

/**
 * 53. 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * data structure: Array
 * algorithm: Divide and Conquer, Dynamic Programming
 * <p>
 * PS. 这道题的经典思想: 两个人爱情的标准, 如果我和你在一起会变得更好, 那我们就在一起, 否则你就去找更好的吧.
 *
 * @author parzulpan
 * @since 2022/4/17
 */
public class Solution53 {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {1};
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 典型的动态规划
     * 假设 dp[i] 表示 [0, i] 区间内各个子区间和的最大值, 则状态转移方程:
     * 1. dp[i-1] > 0 时, dp[i] = nums[i] + dp[i-1];
     * 2. dp[i-1] <= 0 时, dp[i] = nums[i];
     */
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        if (Objects.equals(length, 0)) {
            return 0;
        }
        if (Objects.equals(length, 1)) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }

    /**
     * 另外可以利用线性树, 使用分治思想进行解答, 会更加的通用, 并且在大规模查询的情况效果更佳.
     * 目前还不会这种思想, 回来学会了在回来补.
     */
    public static int maxSubArrayV2(int[] nums) {

        return 0;
    }
}
