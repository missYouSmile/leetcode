package cn.belong.practice.list;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO. 136
 */
public class SingleNumber {

    /**
     * leetcode solution : approach 4
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public int singleNumber02(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else
                map.put(num, 0);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
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
            if (entry.getValue() < 2)
                return entry.getKey();
        }
        return 0;
    }

    @Test
    public void yh() {
        System.out.println(1321 ^ 1321);
        System.out.println(1321 ^ 0);
        System.out.println(0 ^ 1321 ^ 15 ^ 1321);


        System.out.println(0 ^ 321 ^ 10 ^ 13291 ^ 321);
    }
}
