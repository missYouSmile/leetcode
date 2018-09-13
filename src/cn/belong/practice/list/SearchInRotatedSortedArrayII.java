package cn.belong.practice.list;

import org.junit.jupiter.api.Test;

/**
 * todo 2018-09-09
 *
 * leetcode NO. 81
 *
 * @author helios
 * @date 2018-09-09 14:59
 * @description
 */
public class SearchInRotatedSortedArrayII {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
     * <p>
     * You are given a target value to search. If found in the array return true, otherwise return false.
     */
    public boolean search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return false;

        int low = 0;
        int high = nums.length - 1;

        while (low + 1 < high) {

            int mid = low + (high - low) / 2;

            if (target == nums[mid]) return true;

            // 234 target 01

            if (nums[low] < nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid;
                    continue;
                }
                low = mid;

            } else if (nums[low] > nums[mid]) {

                if (target >= nums[low]) {
                    high = mid;
                    continue;
                }

                low = mid;
            } else {
                if (target <= nums[low]) {
                    high = mid;
                }
            }
        }

        if (nums[low] == target) return true;

        if (nums[high] == target) return true;

        return false;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 1, 1};
        System.out.println(search(nums, 3));

    }
}
