package cn.belong.practice.tree;

/**
 * leetcode NO. 99
 *
 * @author shiwen.chen
 * @date 2018-09-21 15:33
 */
public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {

    }

    private TreeNode recover(TreeNode node) {

        if (node == null)
            return null;

        if (node.left != null) {

        }

        return null;
    }

    private TreeNode leftRotate(TreeNode node) {
        TreeNode root = node.right;
        node.right = root.left;
        root.left = node;
        return root;
    }

    private TreeNode rightRotate(TreeNode node) {
        TreeNode root = node.left;
        node.left = root.right;
        root.right = node;
        return root;
    }
}
