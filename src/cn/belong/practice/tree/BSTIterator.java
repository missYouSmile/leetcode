package cn.belong.practice.tree;

import java.util.Stack;

/**
 * leetcode NO. 173
 *
 * @author shiwen.chen
 * @date 2018-09-13 16:45
 */
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }


    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode ret = stack.pop();
        if (ret.right != null) {
            TreeNode cur = ret.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return ret.val;
    }

}
