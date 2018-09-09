package cn.belong.practice.list;

/**
 * leetcode NO. 1
 *
 * @author helios
 * @date 2018-09-09 11:25
 * @description
 */
public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */
    public int[] twoSum(int[] nums, int target) {

        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index1 = i;
                    index2 = j;
                    return new int[]{index1, index2};
                }
            }
        }

        return new int[]{index1, index2};
    }

}
