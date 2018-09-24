package cn.belong.practice.ads.rb;


/**
 * 红黑树
 *
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

        root = add(root, e);
        root.color = BLACK;

    }

    public void remove(E e) {
        Node node = find(root, e);
        if (node == null) {
            return;
        }
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        size--;
        if (node.val.compareTo(e) > 0) {
            node.left = remove(node.left, e);
        } else if (node.val.compareTo(e) < 0) {
            node.right = remove(node.right, e);
        } else {
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                // all not null
                Node tempNode = findMax(node.left);
                tempNode.left = remove(node.left, e);
                tempNode.right = node.right;
            }
        }

        // 维护颜色和黑平衡
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }

    public Node add(Node node, E e) {

        if (node == null) {
            node = new Node(e);
            root.color = BLACK;
            size++;
            return node;
        }

        if (node.val.compareTo(e) > 0) {
            node.right = add(node.right, e);
        } else if (node.val.compareTo(e) < 0)
            node.left = add(node.left, e);
        else {
            // node.val.compareTo(e) == 0 set operation
            // node.val = e;
        }

        // current is red and the left is red
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }

    private Node find(Node node, E e) {
        if (node.val.compareTo(e) == 0)
            return node;
        if (node.val.compareTo(e) > 0)
            return find(node.left, e);
        return find(node.right, e);
    }

    private Node findMin(Node node) {
        if (node.left == null)
            return node;
        return findMin(node.left);
    }

    private Node findMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    /**
     * 颜色翻转
     *
     * @param node 被操作节点
     */
    private void flipColors(Node node) {
        node.left.color = node.color;
        node.right.color = node.color;
        node.color = RED;
    }


    /**
     * 判断节点是否为红色
     *
     * @param node 判断节点是否是红色的
     */
    private boolean isRed(Node node) {
        return node != null && node.color;
    }

    /**
     * 左旋转节点,并返回旋转之后的根节点
     */
    private Node leftRotate(Node node) {

        Node ret = node.right;
        Node temp = ret.left;

        ret.left = node;
        node.right = temp;
        ret.color = node.color;
        node.color = RED;

        return ret;
    }

    /**
     * 右旋转节点,并返回旋转之后的根
     */
    private Node rightRotate(Node node) {

        Node newNode = node.left;
        Node temp = newNode.right;

        newNode.right = node;
        node.left = temp;

        newNode.color = node.color;
        node.color = RED;

        return newNode;
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
            color = RED;
        }
    }

}
