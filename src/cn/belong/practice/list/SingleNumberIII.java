package cn.belong.practice.list;

import java.util.HashSet;

/**
 * leetcode NO 260: Single Number III
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        HashSet<Integer> temp = new HashSet<>();
        for (int num : nums) {
            if (temp.contains(num)) {
                temp.remove(num);
            } else {
                temp.add(num);
            }
        }

        int[] result = new int[2];
        int index = 0;
        for (Integer res : temp) {
            result[index++] = res;
        }

        return result;
    }

}
