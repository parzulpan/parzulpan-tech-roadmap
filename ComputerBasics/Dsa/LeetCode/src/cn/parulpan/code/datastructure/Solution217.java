package cn.parulpan.code.datastructure;

import java.util.HashSet;
import java.util.Objects;

/**
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 * <p>
 * data structure: Array, HashMap
 * algorithm: Sorting
 *
 * @author parzulpan
 * @since 2022/4/17
 */
public class Solution217 {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int[] nums = {1,2,3,4};
        int[] nums = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(containsDuplicate(nums));
    }

    /**
     * 判断长度
     */
    public static boolean containsDuplicate(int[] nums) {
        int length = nums.length;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return !Objects.equals(length, set.size());
    }

    /**
     * 判断值
     */
    public static boolean containsDuplicateV2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            // num 已存在
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}
