package cn.belong.practice.ads.rb;


/**
 * @author shiwen.chen
 * @date 2018-09-19 19:04
 */
public class RBTree<E extends Comparable<E>> {

    private Node root;
    private int size;

    public RBTree() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (e == null)
            throw new NullPointerException("val is must not be null");

        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }

    }

    private static final Boolean RED = Boolean.TRUE;
    private static final Boolean BLACK = Boolean.FALSE;

    private class Node {
        E val;
        Node left;
        Node right;

        boolean color;

        Node(E val) {
            this.val = val;
            color = BLACK;
        }
    }

}
