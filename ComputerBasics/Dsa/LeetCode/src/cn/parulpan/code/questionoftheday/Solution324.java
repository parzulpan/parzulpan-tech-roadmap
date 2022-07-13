package cn.parulpan.code.questionoftheday;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * https://leetcode.cn/problems/wiggle-sort-ii/
 * <p>
 * data structure: 数组
 * algorithm: 分治 快速选择 排序
 *
 * @author parzulpan
 * @since 2022/06/28
 */
public class Solution324 {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 1, 1, 6, 4};
        System.out.println(Arrays.toString(nums1));
        new Solution324().wiggleSort(nums1);
        System.out.println(Arrays.toString(nums1));

        System.out.println();

        int[] nums2 = {1, 3, 2, 2, 3, 1};
        System.out.println(Arrays.toString(nums2));
        new Solution324().wiggleSort(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }
}
