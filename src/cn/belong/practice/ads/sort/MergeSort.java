package cn.belong.practice.ads.sort;

import java.util.Arrays;

public class MergeSort {

    private static void sort(Integer[] arr, int l, int r) {

        if (l >= r)
            return;

        int mid = l + (r - l) / 2;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        merge0(arr, l, mid, r);
    }

    /**
     * 原地merge(移动次数太多,性能问题)
     *
     * @param arr 数组
     * @param l   开始位置
     * @param mid 中间位置
     * @param r   结束位置
     */
    private static void merge(Integer[] arr, int l, int mid, int r) {

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

    /**
     * 空间换时间 O(NlogN)
     *
     * @param arr 数组
     * @param l   开始位置
     * @param mid 中间位置
     * @param r   结束位置
     */
    private static void merge0(Integer[] arr, int l, int mid, int r) {

        Integer[] temp = new Integer[r - l + 1];

        int li = l;
        int ri = mid + 1;
        int ti = 0;
        // log(N)
        while (li <= mid && ri <= r) {
            if (arr[li] < arr[ri])
                temp[ti] = arr[li++];
            else
                temp[ti] = arr[ri++];
            ti++;
        }

        // 两个 while 只可能执行一个
        while (li <= mid) {
            temp[ti++] = arr[li++];
        }

        while (ri <= r) {
            temp[ti++] = arr[ri++];
        }

        // N
        for (int i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

    public static void sort(Integer[] arr) {
        if (arr == null || arr.length < 1)
            return;
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 43, 54, 61, 4, 3, 13, 54, 24, 31};
        System.out.println(Arrays.toString(arr) + " | " + arr.length);
        sort(arr);
        System.out.println(Arrays.toString(arr) + " | " + arr.length);
    }
}
