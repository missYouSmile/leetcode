package cn.belong.practice.ads.sort;

import java.util.Arrays;

/**
 * @author shiwen.chen
 * @date 2018-10-17 09:38
 */
public class ThreeQuickSort {

    public static void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Integer[] arr, int l, int r) {

        if (l >= r)
            return;

        int mid = l + (r - l) / 2;

        // 选择中间元素作为基准数,并且放到最左边
        swap(arr, mid, l);

        // 初始化 = 基准数的 左右边界
        int ml = l;
        int mr = r + 1;

        int i = l + 1;

        while (i < mr) {

            if (arr[i] > arr[l]) {
                swap(arr, i, --mr);
            } else if (arr[i] < arr[l]) {
                swap(arr, i++, ++ml);
            } else {
                i++;
            }
        }

        swap(arr, l, ml);

        sort(arr, l, ml - 1);
        sort(arr, mr, r);
    }

    private static void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 32, 34, 54, 652, 32, 43, 65, 1234, 667532, 43, 43};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
