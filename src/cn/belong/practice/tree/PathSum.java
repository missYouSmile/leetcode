package cn.belong.practice.tree;

import java.util.Stack;

/**
 * leetcode NO. 112
 *
 * @author shiwen.chen
 * @date 2018-11-09 16:14
 */
public class PathSum {

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     *
     * Note: A leaf is a node with no children.
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return sum(root, sum, root.val);
    }

    public boolean sum(TreeNode node, int sum, int rs) {
        if (node == null)
            return false;

        if (isLeaf(node) && sum == rs)
            return true;

        if (node.left != null)
            if (sum(node.left, sum, rs + node.left.val))
                return true;

        if (node.right != null)
            if (sum(node.right, sum, rs + node.right.val))
                return true;

        return false;
    }

    public boolean hasPathSum01(TreeNode root, int sum) {

        if (root == null)
            return false;

        Stack<TreeNode> holder = new Stack<>();
        holder.push(root);

        while (!holder.isEmpty()) {
            TreeNode top = holder.pop();

            if (top.val == sum && isLeaf(top))
                return true;

            if (top.left != null) {
                top.left.val += top.val;
                holder.push(top.left);
            }

            if (top.right != null) {
                top.right.val += top.val;
                holder.push(top.right);
            }
        }

        return false;
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null)
            throw new IllegalArgumentException("Error : node null");
        return node.left == null && node.right == null;
    }


    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(11);
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(2);
        boolean ret = pathSum.hasPathSum(root, 22);
        System.out.println("ret = " + ret);
    }
}
