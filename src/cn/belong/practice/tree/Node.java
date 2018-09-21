package cn.belong.practice.tree;

import java.util.List;

/**
 * @author shiwen.chen
 * @date 2018-09-21 15:22
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
