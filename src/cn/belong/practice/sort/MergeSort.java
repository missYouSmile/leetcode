package cn.belong.practice.sort;

import java.util.Arrays;

public class MergeSort {

    private static void sort(int[] arr, int l, int r) {

        if (l >= r)
            return;

        int mid = l + (r - l) / 2;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    /**
     * 原地merge
     *
     * @param arr 数组
     * @param l   开始位置
     * @param mid 中间位置
     * @param r   结束位置
     */
    private static void merge(int[] arr, int l, int mid, int r) {

        while (mid < r) {
            int temp = arr[mid + 1];
            for (int j = mid; j >= l; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            mid++;
        }

    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 1)
            return;
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 43, 54, 61, 4, 3, 13, 54, 24, 31};
        System.out.println(Arrays.toString(arr) + " | " + arr.length);
        sort(arr);
        System.out.println(Arrays.toString(arr) + " | " + arr.length);
    }
}
