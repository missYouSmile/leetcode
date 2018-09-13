package cn.belong.practice.list;

/**
 * leetcode NO. 287
 *
 * @author shiwen.chen
 * @date 2018-09-13 16:25
 */
public class FindTheDuplicateNumber {

    /**
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate
     * number, find the duplicate one.
     */
    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return nums[i];
            }
        }

        return 0;
    }

}
