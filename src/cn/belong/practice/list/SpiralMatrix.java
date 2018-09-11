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
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return list;

        if (matrix[0] == null || matrix[0].length == 0)
            return list;

        int column = matrix.length;
        int line = matrix[0].length;

        int left = 0;
        int right = line;

        int top = 0;
        int depth = column;

        while (depth > top && left < right) {
            addWidthUp(list, matrix, top, left, right);
            top++;
            if (top == depth)
                break;
            addHeightUp(list, matrix, right - 1, top, depth);
            right--;
            if (left == right)
                break;
            addWidthDown(list, matrix, depth - 1, left, right - 1);
            depth--;
            if (top == depth)
                break;
            addHeightDown(list, matrix, left, top, depth - 1);
            left++;
            if (left == right)
                break;
            System.out.println("left -> " + left + "right -> " + right + " top -> " + top + "depth -> " + depth);
        }

        return list;
    }


    private void addWidthUp(List<Integer> list, int[][] matrix, int line, int min, int max) {
        for (int i = min; i < max; i++) {
            list.add(matrix[line][i]);
        }
    }

    private void addWidthDown(List<Integer> list, int[][] matrix, int line, int min, int max) {
        for (int i = max; min <= i; i--) {
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

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };

        List<Integer> list = spiralOrder(matrix);

        System.out.println(list);


    }

}
