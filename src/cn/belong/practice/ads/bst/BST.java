package cn.belong.practice.ads.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiwen.chen
 * @date 2018-09-14 20:51
 */
public class BST<E extends Comparable<E>> {

    private Node root;

    public BST(E val) {
        this.root = new Node(val);
    }

    public BST() {

    }

    /**
     * 添加元素
     *
     * @param val 待添加元素
     */
    public void add(E val) {
        root = add(root, val);
    }

    /**
     * 删除最大值
     *
     * @return 树中的最大值
     */
    public E removeMax() {

        if (root == null)
            throw new NullPointerException("the BST is empty");

        Node max = findMax(root);

        root = removeMax(root);

        return max.val;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node findMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    /**
     * 删除最小值
     *
     * @return 返回删除的值
     */
    public E removeMin() {
        if (root == null)
            throw new RuntimeException("BST is empty");
        Node min = findMin(root);
        root = removeMin(root);
        return min.val;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node findMin(Node node) {
        if (node.left == null)
            return node;
        return findMin(node.left);
    }

    public List<E> preOrder() {
        List<E> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node root, List<E> list) {
        if (root == null)
            return;
        preOrder(root.left, list);
        list.add(root.val);
        preOrder(root.right, list);
    }

    /**
     * node 中 添加 newNode
     *
     * @return 返回新的树的根
     */
    private Node add(Node node, E val) {

        if (node == null)
            return new Node(val);

        if (node.val.compareTo(val) >= 0)
            node.left = add(node.left, val);
        else
            node.right = add(node.right, val);

        return node;
    }

    private class Node {
        E val;
        Node left;
        Node right;

        Node(E val) {
            if (val == null)
                throw new NullPointerException("the BST val must be not null");
            this.val = val;
        }
    }
}
