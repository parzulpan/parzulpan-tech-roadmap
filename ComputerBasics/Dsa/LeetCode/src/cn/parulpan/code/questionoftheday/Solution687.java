package cn.parulpan.code.questionoftheday;

import cn.parulpan.code.common.TreeNode;

/**
 * 687. 最长同值路径
 * https://leetcode.cn/problems/longest-univalue-path/
 * <p>
 * data structure: 树 二叉树
 * algorithm: 深度优先搜索
 *
 * @author parzulpan
 * @since 2022/09/02
 */
public class Solution687 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = null;
        node2.right = node5;
        node3.left = null;
        node3.right = null;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;

        System.out.println(new Solution687().longestUnivaluePath(root));
    }

    int max = 0;

    /**
     *
     */
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);

        return max;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0, cur = 0, left = dfs(root.left), right = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            ans = left + 1;
            cur += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            ans = Math.max(ans, right + 1);
            cur += right + 1;
        }
        max = Math.max(max, cur);

        return ans;
    }
}
