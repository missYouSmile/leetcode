package cn.belong.practice.tree;

/**
 * leetcode NO. 563
 *
 * @author shiwen.chen
 * @date 2018-09-19 19:22
 */
public class BinaryTreeTilt {

    /**
     * Given a binary tree, return the tilt of the whole tree.
     *
     * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
     *
     * Null node has tilt 0.
     *
     * The tilt of the whole tree is defined as the sum of all nodes' tilt.
     */
    public int findTilt(TreeNode root) {

        if (root == null)
            return 0;

        int lt = sum(root.left);
        int rt = sum(root.right);

        return Math.abs(lt - rt) + findTilt(root.left) + findTilt(root.right);
    }

    private int sum(TreeNode node) {
        if (node == null)
            return 0;
        return node.val + sum(node.left) + sum(node.right);
    }
}
