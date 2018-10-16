package cn.belong.practice.ads.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author helios
 * @date 2018-09-15 16:14
 * @description
 */
public class QuickSort {

    public static <E extends Comparable<E>> void sort(E[] arr) {

        if (arr == null || arr.length <= 1)
            return;

        qSort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void qSort(E[] arr, int left, int right) {

        if (left >= right)
            return;


        // left 与 mid 交换位置 增加参照元素的 随机性
        swap(arr, left, left + (right - left) / 2);
        int partition = left;

        // left 之后的每个元素与 left （当前的left 存的 mid）进行比对，满足条件的一次放在 left 之后的位置
        for (int i = left + 1; i <= right; i++) {
            if (arr[left].compareTo(arr[i]) > 0)
                swap(arr, ++partition, i);
        }

        // left 后 最后一个 被交换的位置的元素 与 left（原 mid ） 交换位置
        // 此时，left -> partition - 1 的元素一点比 partition 位置的元素小，即: 找到了 partition 的位置
        swap(arr, partition, left);

        // 分别对 partition 之前，之后的两个区域的元素进行同样的操作
        qSort(arr, left, partition - 1);
        qSort(arr, partition + 1, right);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    @Test
    public void test() {
        Integer[] arr = {32, 43, 54, 31, 654, 654, 76, 243, 42, 658, 100};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
