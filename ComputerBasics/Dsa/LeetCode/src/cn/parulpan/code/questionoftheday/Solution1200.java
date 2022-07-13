package cn.parulpan.code.questionoftheday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 * https://leetcode.cn/problems/minimum-absolute-difference/
 * <p>
 * 数据结构: 数组
 * 算法: 排序
 *
 * @author parzulpan
 * @since 2022/07/04
 */
public class Solution1200 {
    public static void main(String[] args) {
        System.out.println(new Solution1200().minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println(new Solution1200().minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        System.out.println(new Solution1200().minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int length = arr.length;
        Arrays.sort(arr);

        int best = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            int temp = arr[i + 1] - arr[i];
            if (temp < best) {
                best = temp;
                result.clear();
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                result.add(pair);
            } else if (temp == best) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                result.add(pair);
            }
        }

        return result;
    }
}
