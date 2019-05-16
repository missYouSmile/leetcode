package cn.belong.practice.ads.tree;

public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        if (arr != null && arr.length > 0) {
            this.data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            this.tree = (E[]) new Object[4 * arr.length];
            buildSegmentTree(0, 0, arr.length - 1);
        }
    }

    public E query(int l, int r) {
        return query(0, 0, data.length - 1, l, r);
    }

    private E query(int index, int L, int R, int queryL, int queryR) {
        if (L == queryL && R == queryR)
            return tree[index];

        int mid = L + (R - L) / 2;

        if (queryL >= mid + 1)
            return query(rightChild(index), mid + 1, R, queryL, queryR);

        else if (queryR <= mid)
            return query(leftChild(index), L, mid, queryL, queryR);

        E right = query(rightChild(index), mid + 1, R, mid + 1, queryR);
        E left = query(leftChild(index), L, mid, queryL, mid);

        return merger.merge(left, right);
    }

    private void buildSegmentTree(int i, int l, int r) {
        if (l == r) {
            tree[i] = data[l];
            return;
        }

        int mid = l + (r - l) / 2;
        int left = leftChild(i);
        int right = rightChild(i);

        buildSegmentTree(left, l, mid);
        buildSegmentTree(right, mid + 1, r);

        tree[i] = merger.merge(tree[left], tree[right]);
    }

    private int leftChild(int parent) {
        return 2 * parent + 1;
    }

    private int rightChild(int parent) {
        return 2 * parent + 2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < tree.length; i++) {
            builder.append(tree[i]);
            if (i != tree.length - 1)
                builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }
}
