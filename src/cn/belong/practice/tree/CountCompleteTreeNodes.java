package cn.belong.practice.tree;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO. 222
 *
 * @author shiwen.chen
 * @date 2018-09-14 11:27
 */
public class CountCompleteTreeNodes {

    /**
     * Given a complete binary tree, count the number of nodes.
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = leftDepth(root.left);
        int r = leftDepth(root.right);

        if (l == r)
            //  (1 << l) 左子树 + curNode 的总数
            return (1 << l) + countNodes(root.right);

        // (1 << r) 右子树 + curNode 的总数
        return (1 << r) + countNodes(root.left);
    }

    // 获取节点的最大高度
    private int leftDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + leftDepth(node.left);
    }


    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(countNodes(root));
    }
}
