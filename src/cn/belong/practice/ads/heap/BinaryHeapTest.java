package cn.belong.practice.ads.heap;

import java.util.Random;

public class BinaryHeapTest {

    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            heap.put(random.nextInt(100));
            System.out.println(heap);
        }
        System.out.println("-----------------------------------");
        System.out.println(heap);
        for (int i = 0; i < 10; i++) {
            Integer value = heap.extract();
            System.out.println(heap + "\t >> " + value);
        }
    }

}
