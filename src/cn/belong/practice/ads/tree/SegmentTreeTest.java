package cn.belong.practice.ads.tree;

public class SegmentTreeTest {

    public static void main(String[] args) {
        Integer[] arr = {1, -2, 4, 2, -3, 0, 5};
        SegmentTree<Integer> tree = new SegmentTree<>(arr, (a, b) -> a + b);
        System.out.println(tree);
        System.out.println(tree.query(0, 4));
        System.out.println(tree.query(1, 5));
    }

}
