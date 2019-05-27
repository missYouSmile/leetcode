package cn.belong.practice.ads.heap;

/**
 * The Binary Heap
 *
 * @param <E> element type
 */
public class BinaryHeap<E extends Comparable<E>> {

    /**
     * default capacity and minimum capacity of BinaryHeap
     */
    private static final int DEFAULT_CAPACITY = 8;

    private E[] data;
    private int size;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        this.data = (E[]) new Comparable[capacity];
    }

    /**
     * Put element into the heap
     *
     * @param e element in heap
     */
    public void put(E e) {
        growthIfNecessary();
        data[size] = e;
        shiftUp(size);
        size++;
    }

    /**
     * Extract element on the top of heap
     */
    public E extract() {
        E e = data[0];
        swap(0, size - 1);
        data[size - 1] = null;
        size--;
        shiftDown(0);
        reduceIfNecessary();
        return e;
    }

    private void growthIfNecessary() {
        if (size >= data.length) {
            E[] newData = (E[]) new Comparable[size * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    private void reduceIfNecessary() {
        if (size <= data.length / 3) {
            int newCapacity = data.length / 2;
            newCapacity = newCapacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : newCapacity;
            E[] newData = (E[]) new Comparable[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            this.data = newData;
        }
    }

    private void shiftDown(int index) {
        int current = index;
        int left;
        while ((left = left(current)) < size) {
            int swapIndex = left;
            int right = right(current);
            if (right < size && data[left].compareTo(data[right]) > 0) {
                swapIndex = right;
            }
            if (data[swapIndex].compareTo(data[current]) < 0) {
                swap(current, swapIndex);
                current = swapIndex;
            } else {
                break;
            }
        }
    }

    private void shiftUp(int size) {
        int current = size;
        int parent;
        while ((parent = parent(current)) >= 0) {
            if (data[current].compareTo(data[parent]) < 0) {
                swap(parent, current);
                current = parent;
            } else
                break;
        }
    }

    private void swap(int a, int b) {
        E tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int parent) {
        return 2 * parent + 1;
    }

    private int right(int parent) {
        return 2 * parent + 2;
    }


    @Override
    public String toString() {
        if (size <= 0)
            return "[]: size: 0";
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i < size - 1)
                builder.append(",");
        }
        builder.append("]: size: ").append(size).append(" | capacity: ").append(data.length);
        return builder.toString();
    }
}
