package cn.belong.practice.list;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO. 35
 *
 * @author helios
 * @date 2018-09-09 13:22
 * @description
 */
public class SearchInsertPosition {


    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     */
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] >= target)
            return start;

        if (nums[end - 1] > target)
            return end - 1;

        if (nums[end - 1] < target)
            return end;

        return 0;
    }

    @Test
    public void test() {

        int[] nums = {1, 3, 5, 6};

        System.out.println(searchInsert(nums, 7));

    }

}
