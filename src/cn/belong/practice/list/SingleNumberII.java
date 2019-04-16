package cn.belong.practice.list;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode NO 137: Single Number II
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 3)
                return entry.getKey();
        }
        return 0;
    }

    public int singleNumber01(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 3)
                return entry.getKey();
        }
        return 0;
    }

}
