package cn.belong.practice.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode NO. 145
 *
 * @author shiwen.chen
 * @date 2018-09-13 19:40
 */
public class BinaryTreePostorderTraversal {


    public List<Integer> postorderTraversal(TreeNode root) {

        // pre order
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode pop = stack.pop();
            list.add(pop.val);

            // right top than left

            if (pop.left != null) {
                stack.push(pop.left);
            }

            if (pop.right != null) {
                stack.push(pop.right);
            }
        }

        // reverse
        List<Integer> ret = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            ret.add(list.get(i));
        }

        return ret;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(2);
        System.out.println(postorderTraversal(root));
    }
}
