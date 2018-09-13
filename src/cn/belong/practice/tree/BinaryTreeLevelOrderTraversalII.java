package cn.belong.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode NO. 107
 *
 * @author helios
 * @date 2018-09-13 23:16
 * @description
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (ie, from left to right, level by level from leaf to root).
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {


        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();

        List<Integer> temp = null;
        queue.add(root);

        while (!queue.isEmpty()) {
            if (temp == null)
                temp = new ArrayList<>();
            TreeNode pop = queue.remove();
            temp.add(pop.val);

            if (pop.left != null)
                nextQueue.add(pop.left);
            if (pop.right != null)
                nextQueue.add(pop.right);

            if (queue.isEmpty()) {
                list.add(temp);
                queue = nextQueue;
                temp = null;
                nextQueue = new LinkedList<>();
            }
        }

        List<List<Integer>> ret = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            ret.add(list.get(i));
        }

        return ret;
    }

}
