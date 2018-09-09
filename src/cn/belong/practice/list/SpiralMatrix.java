package cn.belong.practice.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode NO. 54
 *
 * @author helios
 * @date 2018-09-09 21:51
 * @description
 */
public class SpiralMatrix {

    /**
     * Given a matrix of m x n elements (m rows, n columns),
     * return all elements of the matrix in spiral order.
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return null;

        if (matrix[0] == null || matrix[0].length == 0)
            return null;

        int width = matrix.length;
        int height = matrix[0].length;


        /*
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
         */

        List<Integer> list = new ArrayList<>();

        int line = 0;
        int minWi = 0;
        int maxWi = width;

        int minHi = 0;
        int maxHi = height;

        while (minHi < maxHi) {
            addWidthUp(list, matrix, line, minWi, maxWi);

            minHi++;
            // add height
            addHeightUp(list, matrix, maxWi - 1, minHi, maxHi - 1);

            maxWi--;
            addWidthDown(list, matrix, maxHi - 1, minWi, maxWi - 1);
            maxHi--;

            addHeightDown(list, matrix, minWi, minHi, maxHi - 1);
            minWi++;
            line++;
        }


        return list;
    }


    private void addWidthUp(List<Integer> list, int[][] matrix, int line, int min, int max) {
        for (int i = min; i < max; i++) {
            list.add(matrix[line][i]);
        }
    }

    private void addWidthDown(List<Integer> list, int[][] matrix, int line, int min, int max) {
        for (int i = max; min < i; i--) {
            list.add(matrix[line][i]);
        }
    }

    private void addHeightUp(List<Integer> list, int[][] matrix, int column, int min, int max) {
        for (int i = min; i < max; i++) {
            list.add(matrix[i][column]);
        }
    }


    private void addHeightDown(List<Integer> list, int[][] matrix, int column, int min, int max) {
        for (int i = max; min <= i; i--) {
            list.add(matrix[i][column]);
        }
    }

    @Test
    public void test() {
//
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> list = spiralOrder(matrix);

        System.out.println(list);


    }

}
