package cn.parulpan.code.questionoftheday;

import cn.parulpan.code.common.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode.cn/problems/trim-a-binary-search-tree/
 * <p>
 * data structure: 树 二叉树 二叉搜索树
 * algorithm: 递归
 *
 * @author parzulpan
 * @since 2022/9/10
 */
public class Solution669 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = null;
        node2.right = node4;
        node3.left = null;
        node3.right = null;
        node4.left = node5;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        System.out.println(node1);
        new Solution669().trimBST(node1, 1,3);
        System.out.println(node1);
    }

    /**
     * 递归处理.
     * 1. 若 root.val < low, 则 root 的左子树必然均小于边界值, 所以递归处理 root 的右子树即可;
     * 2. 若 root.val > high, 则 root 的右子树必然均大于边界值, 所以递归处理 root 的左子树即可;
     * 3. 若 root.val 满足要求, 则 root 继续保留, 递归处理左右子树即可;
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
