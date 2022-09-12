package cn.parulpan.code.questionoftheday;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 * <p>
 * data structure: 数组
 * algorithm: 排序 二分查找
 *
 * @author parzulpan
 * @since 2022/09/12
 */
public class Solution1608 {
    public static void main(String[] args) {
        Solution1608 solution1608 = new Solution1608();
        System.out.println(solution1608.specialArray(new int[]{3, 5}));
        System.out.println(solution1608.specialArray(new int[]{0, 0}));
        System.out.println(solution1608.specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(solution1608.specialArray(new int[]{3, 6, 7, 7, 0}));
    }

    /**
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     */
    public static int X_MAX = 1001;

    /**
     * 可以通过枚举的方式找到 x，而对于每个 x 的合法性检查，我们需要快速知道 nums 中比 x 大的数的个数，这可以通过先排序然后二分查找。
     */
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int x = 0; x < X_MAX; x++) {
            // 二分查找
            int left = 0, right = length - 1;
            while (left < right) {
                int mid = left + right >> 1;
                if (nums[mid] >= x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 元素大于或者等于 x 并且 x 等于其数量
            if (nums[right] >= x && x == length - left) {
                return x;
            }
        }
        return -1;
    }
}
