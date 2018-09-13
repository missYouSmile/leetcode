package cn.belong.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO. 145
 *
 * @author shiwen.chen
 * @date 2018-09-13 19:40
 */
public class BinaryTreePostorderTraversal {


    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;
        stack.push(root);

        TreeNode cur = root;
        while (!stack.isEmpty()) {



        }

        return list;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(postorderTraversal(root));
    }
}
