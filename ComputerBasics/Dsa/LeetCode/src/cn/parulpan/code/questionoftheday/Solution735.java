package cn.parulpan.code.questionoftheday;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 735. 行星碰撞
 * https://leetcode.cn/problems/asteroid-collision/
 * <p>
 * data structure: 数组 栈
 * algorithm: 模拟
 *
 * @author parzulpan
 * @since 2022/07/13
 */
public class Solution735 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(new int[]{-8, 8})));
        System.out.println(Arrays.toString(new Solution735().asteroidCollision(new int[]{10, 2, -5})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            // 当前行星是否存活
            boolean live = true;

            while (live && !deque.isEmpty() && deque.peekLast() > 0 && asteroid < 0) {
                int peekLast = deque.peekLast();
                live = peekLast < -asteroid;
                // 栈顶行星爆炸
                if (peekLast <= -asteroid) {
                    deque.pollLast();
                }
            }

            // 当前行星存活则加入栈
            if (live) {
                deque.addLast(asteroid);
            }
        }

        int size = deque.size();
        int[] ans = new int[size];
        while (!deque.isEmpty()) {
            ans[--size] = deque.pollLast();
        }

        return ans;
    }
}
