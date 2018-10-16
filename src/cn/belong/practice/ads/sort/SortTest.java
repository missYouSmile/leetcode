package cn.belong.practice.ads.sort;

/**
 * @author shiwen.chen
 * @date 2018-10-16 17:51
 */
public class SortTest {

    public static void main(String[] args) {

        quickSort(getArr());

        mergeSort(getArr());

    }

    private static void mergeSort(Integer[] arr) {
        long start = System.nanoTime();
        MergeSort.sort(arr);
        long end = System.nanoTime();
        System.out.println("merge sort nano time : " + (end - start));
    }

    private static void quickSort(Integer[] arr) {
        long start = System.nanoTime();
        QuickSort.sort(arr);
        long end = System.nanoTime();
        System.out.println("quick sort nano time : " + (end - start));
    }

    private static Integer[] getArr() {
        int count = 100000;

        Integer[] arr = new Integer[count];

        for (int i = 0; i < count; i++) {
            arr[i] = (int) ((Math.random() * Integer.MAX_VALUE));
        }

        return arr;

    }

}
