package cn.belong.practice.ads;

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
        Node newNode = new Node(val);
        if (root == null)
            root = newNode;
        else
            root = add(root, newNode);
    }

    /**
     * node 中 添加 newNode
     *
     * @return 返回新的树的根
     */
    private Node add(Node node, Node newNode) {

        if (node == null)
            return newNode;

        if (node.val.compareTo(newNode.val) >= 0)
            node.left = add(node.left, newNode);
        else
            node.right = add(node.right, newNode);

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
