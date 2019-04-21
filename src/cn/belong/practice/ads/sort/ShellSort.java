package cn.belong.practice.ads.sort;

/**
 * shell sort in <<algorithms 4th>>
 */
public class ShellSort {

    public static <E extends Comparable<E>> void sort(E[] elements) {
        int N = elements.length;
        int h = 1;

        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(elements[j], elements[j - h]); j -= h) {
                    exchange(elements, j, j - h);
                }
            }
            h = h / 3;
        }

    }

    private static <E extends Comparable<E>> void exchange(E[] elements, int j, int i) {
        E temp = elements[j];
        elements[j] = elements[i];
        elements[i] = temp;
    }

    private static <E extends Comparable<E>> boolean less(E a, E b) {
        return a.compareTo(b) < 0;
    }
}
