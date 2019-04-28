package cn.belong.practice.str;

import org.junit.jupiter.api.Test;

/**
 * leetcode NO 5 Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String str) {
        if (str == null || str.equals("")) return "";

        int maxLength = 1;
        int s = 0;
        int h = 0;

        for (int i = 1; i < str.length(); i++) {
            // The gap before index 'i' as center
            int low = i - 1;
            int high = i;
            while (low >= 0 && high < str.length() &&
                    str.charAt(low) == str.charAt(high)) {
                if (maxLength < high - low + 1) {
                    s = low;
                    h = high;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }

            // The 'i' as center index
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < str.length() &&
                    str.charAt(low) == str.charAt(high)) {
                if (maxLength < high - low + 1) {
                    s = low;
                    h = high;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }

        }

        return str.substring(s, h + 1);
    }


    @Test
    public void test() {
        System.out.println(longestPalindrome("forgeeksskeegfor"));
    }

}
