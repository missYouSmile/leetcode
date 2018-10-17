package cn.belong.practice.ads.sort;

/**
 * @author shiwen.chen
 * @date 2018-10-16 17:51
 */
public class SortTest {

    public static void main(String[] args) {

        int count = 1000000;

        Integer[] arr = getArr(count);
        Integer[] a1 = copy(arr);
        quickSort(a1);
        isSorted(a1);

        Integer[] a2 = copy(arr);
        mergeSort(a2);
        isSorted(a2);

        Integer[] a3 = copy(arr);
        quickSort3(a3);
        isSorted(a3);
    }

    private static void mergeSort(Integer[] arr) {
        long start = System.nanoTime();
        MergeSort.sort(arr);
        long end = System.nanoTime();
        System.out.println("merge sort nano time : " + (end - start) / 1000000000.0);
    }

    private static void quickSort(Integer[] arr) {
        long start = System.nanoTime();
        QuickSort.sort(arr);
        long end = System.nanoTime();
        System.out.println("quick sort nano time : " + (end - start) / 1000000000.0);
    }

    private static void quickSort3(Integer[] arr) {
        long start = System.nanoTime();
        ThreeQuickSort.sort(arr);
        long end = System.nanoTime();
        System.out.println("3 ways quick sort nano time : " + (end - start) / 1000000000.0);
    }

    private static Integer[] getArr(int count) {

        Integer[] arr = new Integer[count];

        for (int i = 0; i < count; i++) {
            arr[i] = (int) ((Math.random() * Integer.MAX_VALUE));
        }

        return arr;

    }

    private static Integer[] copy(Integer[] arr) {
        Integer[] ret = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    private static void isSorted(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                throw new RuntimeException("non sorted array!");
        }
    }
}
