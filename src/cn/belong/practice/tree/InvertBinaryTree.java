package cn.belong.practice.tree;

/**
 * leetcode NO. 226
 *
 * @author shiwen.chen
 * @date 2018-09-19 19:51
 */
public class InvertBinaryTree {

    /**
     * Invert a binary tree.
     *
     * Example:
     *
     * Input:
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * Output:
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        swap(root);

        return root;
    }

    private TreeNode swap(TreeNode node) {

        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        if (node.right != null) {
            swap(node.right);
        }
        if (node.left != null) {
            swap(node.left);
        }

        return node;
    }

}
