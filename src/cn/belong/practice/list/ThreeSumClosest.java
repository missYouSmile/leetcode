package cn.belong.practice.list;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode NO. 16
 *
 * @author helios
 * @date 2018-09-09 12:09
 * @description
 */
public class ThreeSumClosest {

    /**
     * Given an array nums of n integers and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * <p>
     * You may assume that each input would have exactly one solution.
     */
    public int threeSumClosest(int[] nums, int target) {

        int minOffset = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int ni = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int nj = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int nk = nums[k];

                    int sum = ni + nj + nk;

                    if (sum == target)
                        return sum;

                    int offset = Math.abs(sum - target);
                    if (minOffset < offset) {
                        continue;
                    }


                    minOffset = offset;
                    minSum = sum;
                }
            }
        }

        return minSum;
    }


    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        int sumClosest = threeSumClosest(nums, 1);
        System.out.println(sumClosest);
    }
}
