package cn.belong.practice.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * leetcode NO. 55
 * @author helios
 * @date 2018-09-09 13:41
 * @description
 */
public class JumpGame {

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Determine if you are able to reach the last index.
     */
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 1)
            return true;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(i);
            }
        }

        if (list.isEmpty())
            return true;

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            int index = it.next();

            int ni = index;
            // all can not jump
            boolean allNotJump = false;
            while (ni >= 0) {
                int offset = index - ni;

                if (nums[ni] > offset || (nums[ni] == offset && (index == nums.length - 1 || nums[index] > 0))) {
                    allNotJump = true;
                    break;
                }

                ni--;
            }

            if (!allNotJump) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

}
