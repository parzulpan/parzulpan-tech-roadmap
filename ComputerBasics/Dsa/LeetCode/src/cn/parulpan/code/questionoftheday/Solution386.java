package cn.parulpan.code.questionoftheday;

import java.util.ArrayList;
import java.util.List;

/**
 * 386.字典序排数
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 * <p>
 * data structure: Trie
 * algorithm: Depth-First Search
 *
 * @author parzulpan
 * @since 2022/04/18
 */
public class Solution386 {
    public static void main(String[] args) {
        System.out.println(new Solution386().lexicalOrder(13));
        System.out.println(new Solution386().lexicalOrder(2));
    }

    static int nodeCnt = 10;
    List<Integer> ret = new ArrayList<>();

    /**
     * 递归实现 DFS
     * 对一个节点数量为 n, 形态类似字典树的多阶树进行深度遍历
     * <p>
     * 0
     * /  \
     * 1    2
     * / \
     * 10 11
     * /
     * 100
     */
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < nodeCnt; i++) {
            dfs(i, n);
        }

        return ret;
    }

    private void dfs(int cur, int limit) {
        if (cur > limit) {
            return;
        }

        ret.add(cur);

        for (int i = 0; i < nodeCnt; i++) {
            dfs(cur * 10 + i, limit);
        }
    }

    
    /**
     * 迭代实现 DFS
     * 共有 n 个数需要被处理, 假设当前处理到的数为 j, 根据字典序规则, 在满足条件的前提下,
     * 我们优先在 j 的后面添加 0 (即 j * 10 < n 满足), 否则我们考虑将上一位回退并进行加一操作
     */
    public List<Integer> lexicalOrderV2(int n) {
        ArrayList<Integer> ret = new ArrayList<>();

        for (int i = 0, j = 1; i < n; i++) {
            ret.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j % 10 == 9 || j + 1 > n) {
                    j /= 10;
                }
                j++;
            }
        }

        return ret;
    }

}
