package cn.belong.practice.list;

/**
 * leetcode NO. 74
 *
 * @author helios
 * @date 2018-09-09 14:20
 * @description
 */
public class Search2DMatrix {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * <p>
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;

        int width = matrix.length - 1;

        while (width >= 0) {
            if (matrix[width][0] > target) {
                width--;
            } else {
                break;
            }
        }

        if (width < 0)
            return false;

        for (int i = 0; i < matrix[width].length; i++) {
            if (matrix[width][i] == target)
                return true;
        }

        return false;
    }

}
