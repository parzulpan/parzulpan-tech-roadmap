package cn.parulpan.code.questionoftheday;

import cn.parulpan.code.common.TreeNode;

import java.util.ArrayDeque;

/**
 * 623. 在二叉树中增加一行
 * https://leetcode.cn/problems/add-one-row-to-tree/
 * <p>
 * data structure: 树 二叉树
 * algorithm: 深度优先搜索 广度优先搜索
 *
 * @author parzulpan
 * @since 2022/08/05
 */
public class Solution623 {
    public static void main(String[] args) {

    }

    /**
     * 根据 BFS 来做，每次 BFS 将整一层进行拓展，同时记录当前深度，当到达第 depth - 1 层，则进行加点操作。
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;

            return ans;
        }

        ArrayDeque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        int cur = 1;
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                TreeNode t = d.pollFirst();
                if (cur == depth - 1) {
                    TreeNode a = new TreeNode(val), b = new TreeNode(val);
                    assert t != null;
                    a.left = t.left;
                    b.right = t.right;
                    t.left = a;
                    t.right = b;
                } else {
                    assert t != null;
                    if (t.left != null) {
                        d.addLast(t.left);
                    }
                    if (t.right != null) {
                        d.addLast(t.right);
                    }
                }
            }
            cur++;
        }

        return root;
    }
}
