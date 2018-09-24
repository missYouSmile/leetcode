package cn.belong.practice.tree;

/**
 * leetcode NO. 99
 *
 * @author shiwen.chen
 * @date 2018-09-21 15:33
 */
public class RecoverBinarySearchTree {

    /**
     * Two elements of a binary search tree (BST) are swapped by mistake.
     * Recover the tree without changing its structure.
     *
     * @param root 二分搜索树的根
     */
    public void recoverTree(TreeNode root) {

        if (root == null || root.left == null || root.right == null)
            return;

        TreeNode inLeft = findInLeft(root.left, root.val);
        TreeNode inRight = findInRight(root.right, root.val);

        if (inLeft != null) {
            int val = root.val;
            root.val = inLeft.val;
            inLeft.val = val;
        }

    }

    private TreeNode findInLeft(TreeNode node, int val) {

        if (node == null) {
            return null;
        }

        if (node.val > val)
            return node;

        TreeNode inLeft = findInLeft(node.left, val);
        TreeNode inLeft1 = findInLeft(node.right, val);

        return inLeft == null ? inLeft1 : inLeft;
    }

    private TreeNode findInRight(TreeNode node, int val) {
        if (node == null || node.val < val) {
            return null;
        }
        TreeNode inRight1 = findInRight(node.left, val);
        TreeNode inRight = findInRight(node.right, val);

        return inRight == null ? inRight1 : inRight;
    }

}
