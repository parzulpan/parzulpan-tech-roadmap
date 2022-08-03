package cn.parulpan.code.questionoftheday;

/**
 * 1184. 公交站间的距离
 * https://leetcode.cn/problems/distance-between-bus-stops/
 * <p>
 * data structure: 数组
 * algorithm: 模拟
 *
 * @author parzulpan
 * @since 2022/07/24
 */
public class Solution1184 {
    public static void main(String[] args) {
        System.out.println(new Solution1184().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
        System.out.println(new Solution1184().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));
        System.out.println(new Solution1184().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
    }

    /**
     * 根据题意进行模拟，用 before 和 after 分别代表向前和往后走两种方式，
     * 用 beforeV 和 afterV 记录两种方式的结果，然后求最小值即可
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int length = distance.length;
        int before = start, after = start, beforeV = 0, afterV = 0;

        while (before != destination) {
            beforeV += distance[before];
            if (++before == length) {
                before = 0;
            }
        }
        while (after != destination) {
            if (--after < 0) {
                after = length - 1;
            }
            afterV += distance[after];
        }

        return Math.min(beforeV, afterV);
    }
}
