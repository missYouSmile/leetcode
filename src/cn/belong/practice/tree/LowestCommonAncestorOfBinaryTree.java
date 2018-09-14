package cn.belong.practice.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * leetcode NO. 236
 *
 * @author shiwen.chen
 * @date 2018-09-14 18:26
 */
public class LowestCommonAncestorOfBinaryTree {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     *
     * According to the definition of LCA on Wikipedia:
     *
     * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     *         _______3______
     *        /              \
     *     ___5__          ___1__
     *    /      \        /      \
     *    6      _2       0       8
     *          /  \
     *          7   4
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        stack.push(root);

        // 获取每个节点的父亲节点
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            if (parent.left != null) {
                map.put(parent.left, parent);
                stack.push(parent.left);
            }
            if (parent.right != null) {
                map.put(parent.right, parent);
                stack.push(parent.right);
            }
        }

        TreeNode qp = map.get(q);
        TreeNode pp = map.get(p);

        // q 的祖先节点集合
        List<TreeNode> qpl = new ArrayList<>();

        while (qp!=null){
            qpl.add(qp);
            qp = map.get(qp);
        }

        // q 的祖先节点是否包含 p
        if(qpl.contains(p))
            return p;

        while (pp!=null){
            // 判断 p 的祖先节点是否为 q
            if(pp == q) {
                return q;
            }
            // 判断 p 的祖先节点是否在 q 的祖先节点集合中
            if(qpl.contains(pp))
                return pp;
            pp = map.get(pp);
        }

        return null;
    }

}
