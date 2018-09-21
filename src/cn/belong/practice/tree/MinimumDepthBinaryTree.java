package cn.belong.practice.tree;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO. 111
 *
 * @author shiwen.chen
 * @date 2018-09-21 13:53
 */
public class MinimumDepthBinaryTree {

    /**
     * Given a binary tree, find its minimum depth.
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * Note: A leaf is a node with no children.
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> curLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        curLevel.push(root);

        int depth = 1;

        while (!curLevel.isEmpty()) {

            TreeNode pop = curLevel.pop();
            if (isLeaf(pop))
                break;

            if (pop.left != null) {
                nextLevel.push(pop.left);
            }

            if (pop.right != null) {
                nextLevel.push(pop.right);
            }

            if (curLevel.isEmpty()) {
                depth++;
                while (!nextLevel.isEmpty()) {
                    curLevel.push(nextLevel.pop());
                }
            }

        }

        return depth;
    }

    private boolean isLeaf(TreeNode node) {
        if (node != null)
            return node.left == null && node.right == null;
        return false;
    }


    @Test
    public void test() {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        System.out.println(minDepth(root));
    }

}
