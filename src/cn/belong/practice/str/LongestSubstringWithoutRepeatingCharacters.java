package cn.belong.practice.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 1;
        Map<Character, Integer> map = new HashMap<>();

        int lowBound = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                lowBound = Math.max(lowBound, map.get(ch) + 1);
            }
            map.put(ch, i);
            maxLength = Math.max(i - lowBound + 1, maxLength);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring01(String s) {
        if (s == null || s.length() < 1)
            return 0;

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> curSet = new HashSet<>();
            int j = i;
            for (; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (curSet.contains(ch)) {
                    break;
                }
                curSet.add(ch);
            }
            if (maxLength < curSet.size()) {
                maxLength = curSet.size();
                if (maxLength > s.length() - i)
                    break;
            }
        }
        return maxLength;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("bbbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
